package com.artisan.coupon.template.service.impl;

import com.artisan.coupon.template.convert.CouponTemplateConverter;
import com.artisan.coupon.template.dao.CouponTemplateDao;
import com.artisan.coupon.template.dao.entity.CouponTemplate;
import com.artisan.coupon.template.service.intf.CouponTemplateService;
import comartisan.coupon.template.api.beans.CouponTemplateInfo;
import comartisan.coupon.template.api.beans.PagedCouponTemplateInfo;
import comartisan.coupon.template.api.beans.TemplateSearchParams;
import comartisan.coupon.template.api.enums.CouponType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券模板类相关操作
 * @date 2022/11/19 21:02
 * @mark: show me the code , change the world
 */

@Slf4j
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Resource
    private CouponTemplateDao couponTemplateDao;


    /**
     * 创建优惠券模板
     */
    @Override
    public CouponTemplateInfo createTemplate(CouponTemplateInfo request) {
        // 单个门店最多可以创建100张优惠券模板
        if (request.getShopId() != null) {
            Integer count = couponTemplateDao.countByShopIdAndAvailable(request.getShopId(), true);
            if (count >= 100) {
                throw new UnsupportedOperationException("exceeded the maximum of coupon templates that you can create");
            }
        }

        // 创建优惠券
        CouponTemplate couponTemplate = CouponTemplate.builder()
                .name(request.getName())
                .description(request.getDesc())
                .category(CouponType.convert(request.getType()))
                .available(true)
                .shopId(request.getShopId())
                .rule(request.getRule())
                .build();


        couponTemplate = couponTemplateDao.save(couponTemplate);
        return CouponTemplateConverter.convert(couponTemplate);
    }

    /**
     * 克隆优惠券模板
     *
     * @param templateId
     * @return
     */
    @Override
    public CouponTemplateInfo cloneTemplate(Long templateId) {
        log.info("cloning template id {}", templateId);

        CouponTemplate source = couponTemplateDao.findById(templateId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Template ID" + templateId));

        CouponTemplate target = new CouponTemplate();
        BeanUtils.copyProperties(source, target);

        target.setAvailable(Boolean.TRUE);
        target.setId(null);

        target = couponTemplateDao.save(target);

        return CouponTemplateConverter.convert(target);
    }

    /**
     * 分页查询优惠券模板
     *
     * @param request
     * @return
     */
    @Override
    public PagedCouponTemplateInfo search(TemplateSearchParams request) {
        CouponTemplate couponTemplate = CouponTemplate.builder()
                .shopId(request.getShopId())
                .category(CouponType.convert(request.getType()))
                .available(request.getAvailable())
                .name(request.getName())
                .build();

        Pageable page = PageRequest.of(request.getPage(), request.getPageSize());
        Page<CouponTemplate> result = couponTemplateDao.findAll(Example.of(couponTemplate), page);

        List<CouponTemplateInfo> couponTemplateInfoList = result.stream()
                .map(CouponTemplateConverter::convert)
                .collect(Collectors.toList());

        PagedCouponTemplateInfo response = PagedCouponTemplateInfo.builder()
                .templateInfoList(couponTemplateInfoList)
                .total(result.getTotalPages())
                .page(request.getPage())
                .build();
        return response;
    }

    public List<CouponTemplateInfo> searchTemplate(CouponTemplateInfo request) {
        CouponTemplate example = CouponTemplate.builder()
                .shopId(request.getShopId())
                .category(CouponType.convert(request.getType()))
                .available(request.getAvailable())
                .name(request.getName())
                .build();
        // 可以用下面的方式做分页查询
//        Pageable page = PageRequest.of(0, 100);
//        templateDao.findAll(Example.of(example), page);
        List<CouponTemplate> result = couponTemplateDao.findAll(Example.of(example));
        return result.stream()
                .map(CouponTemplateConverter::convert)
                .collect(Collectors.toList());
    }


    /**
     * 通过ID查询优惠券模板
     */
    @Override
    public CouponTemplateInfo loadTemplateInfo(Long id) {
        Optional<CouponTemplate> couponTemplate = couponTemplateDao.findById(id);

        return couponTemplate.isPresent() ? CouponTemplateConverter.convert(couponTemplate.get()) : null;
    }

    /**
     * 将券无效化
     *
     * @param id
     */
    @Override
    public void deleteTemplate(Long id) {
        int rows = couponTemplateDao.makeCouponUnavailable(id);
        if (rows <= 0) {
            throw new IllegalArgumentException("Template Not Found: " + id);
        }

    }

    /**
     * 批量读取模板
     */
    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids) {
        List<CouponTemplate> templates = couponTemplateDao.findAllById(ids);

        return templates.stream().map(CouponTemplateConverter::convert)
                .collect(Collectors.toMap(CouponTemplateInfo::getId, Function.identity()));
    }
}
    
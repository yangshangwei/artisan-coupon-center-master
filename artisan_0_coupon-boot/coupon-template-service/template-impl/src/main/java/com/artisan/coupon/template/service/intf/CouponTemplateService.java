package com.artisan.coupon.template.service.intf;

import comartisan.coupon.template.api.beans.CouponTemplateInfo;
import comartisan.coupon.template.api.beans.PagedCouponTemplateInfo;
import comartisan.coupon.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券模板类相关操作接口
 * @date 2022/11/19 21:00
 * @mark: show me the code , change the world
 */
public interface CouponTemplateService {

    /**
     * 创建优惠券模板
     *
     * @param request
     * @return
     */
    CouponTemplateInfo createTemplate(CouponTemplateInfo request);

    CouponTemplateInfo cloneTemplate(Long templateId);

    /**
     * 模板查询（分页）
     *
     * @param request
     * @return
     */
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    /**
     * 通过模板ID查询优惠券模板
     *
     * @param id
     * @return
     */
    CouponTemplateInfo loadTemplateInfo(Long id);

    /**
     * 让优惠券模板无效
     *
     * @param id
     */
    void deleteTemplate(Long id);

    /**
     * 批量查询
     * Map是模板ID，key是模板详情
     *
     * @param ids
     * @return
     */
    Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);
}
    
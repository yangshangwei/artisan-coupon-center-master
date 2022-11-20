package com.artisan.coupon.template.convert;

import com.artisan.coupon.template.dao.entity.CouponTemplate;
import comartisan.coupon.template.api.beans.CouponTemplateInfo;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/11/19 21:52
 * @mark: show me the code , change the world
 */
public class CouponTemplateConverter {

    public static CouponTemplateInfo convert(CouponTemplate template) {
        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getCategory().getCode())
                .shopId(template.getShopId())
                .available(template.getAvailable())
                .rule(template.getRule())
                .build();
    }
}
    
package com.artisan.coupon.template.dao.convert;

import comartisan.coupon.template.api.enums.CouponType;

import javax.persistence.AttributeConverter;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/11/19 20:27
 * @mark: show me the code , change the world
 */
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {
    @Override
    public String convertToDatabaseColumn(CouponType attribute) {
        return attribute.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
    
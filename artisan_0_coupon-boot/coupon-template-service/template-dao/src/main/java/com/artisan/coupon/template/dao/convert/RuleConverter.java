package com.artisan.coupon.template.dao.convert;

import com.alibaba.fastjson.JSON;
import comartisan.coupon.template.api.beans.rules.TemplateRule;

import javax.persistence.AttributeConverter;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/11/19 20:40
 * @mark: show me the code , change the world
 */
public class RuleConverter implements AttributeConverter<TemplateRule, String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        return JSON.toJSONString(templateRule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }
}
    
package com.artisan.coupon.calculation.template.impl;

import com.artisan.coupon.calculation.template.AbstractRuleTemplate;
import com.artisan.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 打折优惠券
 * @date 2022/11/20 17:37
 * @mark: show me the code , change the world
 */
@Slf4j
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        // 计算使用优惠券之后的价格
        Long newPrice = convertToDecimal(shopAmount * (quota.doubleValue() / 100));
        log.debug("original price={}, new price={}", totalAmount, newPrice);
        return newPrice;
    }
}
    
package com.artisan.coupon.calculation.template.impl;

import com.artisan.coupon.calculation.api.beans.ShoppingCart;
import com.artisan.coupon.calculation.template.AbstractRuleTemplate;
import com.artisan.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 空实现
 * @date 2022/11/20 17:51
 * @mark: show me the code , change the world
 */

@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        // 获取订单总价
        Long orderTotalAmount = getTotalPrice(order.getProducts());

        order.setCost(orderTotalAmount);
        return order;
    }


    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }
}
    
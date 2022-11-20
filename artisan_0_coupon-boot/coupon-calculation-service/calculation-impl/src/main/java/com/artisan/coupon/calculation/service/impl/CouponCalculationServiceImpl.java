package com.artisan.coupon.calculation.service.impl;

import com.alibaba.fastjson.JSON;
import com.artisan.coupon.calculation.api.beans.ShoppingCart;
import com.artisan.coupon.calculation.api.beans.SimulationOrder;
import com.artisan.coupon.calculation.api.beans.SimulationResponse;
import com.artisan.coupon.calculation.service.intf.CouponCalculationService;
import com.artisan.coupon.calculation.template.CouponTemplateFactory;
import com.artisan.coupon.calculation.template.RuleTemplate;
import com.google.common.collect.Lists;
import comartisan.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/11/20 18:01
 * @mark: show me the code , change the world
 */
@Slf4j
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {

    @Autowired
    private CouponTemplateFactory factory;

    @Override
    public ShoppingCart calculatorOrderPrice(ShoppingCart shoppingCart) {
        log.info("calculate order price: {}", JSON.toJSONString(shoppingCart));
        RuleTemplate template = factory.getTemplate(shoppingCart);
        return template.calculate(shoppingCart);
    }

    @Override
    public SimulationResponse simulateOrder(SimulationOrder order) {
        SimulationResponse response = new SimulationResponse();
        Long minOrderPrice = Long.MAX_VALUE;

        // 计算每一个优惠券的订单价格
        for (CouponInfo coupon : order.getCouponInfos()) {
            ShoppingCart cart = new ShoppingCart();
            cart.setProducts(order.getProducts());
            cart.setCouponInfos(Lists.newArrayList(coupon));
            cart = factory.getTemplate(cart).calculate(cart);

            Long couponId = coupon.getId();
            Long orderPrice = cart.getCost();

            // 设置当前优惠券对应的订单价格
            response.getCouponToOrderPrice().put(couponId, orderPrice);

            // 比较订单价格，设置当前最优优惠券的ID
            if (minOrderPrice > orderPrice) {
                response.setBestCouponId(coupon.getId());
                minOrderPrice = orderPrice;
            }
        }
        return response;
    }
}
    
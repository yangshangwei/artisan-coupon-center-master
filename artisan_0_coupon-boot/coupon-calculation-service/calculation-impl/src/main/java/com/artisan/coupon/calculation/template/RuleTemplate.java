package com.artisan.coupon.calculation.template;

import com.artisan.coupon.calculation.api.beans.ShoppingCart;

/**
 * @author artisan
 */
public interface RuleTemplate {

    /**
     * 计算优惠券
     *
     * @param shoppingCart
     * @return
     */
    ShoppingCart calculate(ShoppingCart shoppingCart);
}

package com.artisan.coupon.calculation.api.beans;

import comartisan.coupon.template.api.beans.CouponInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 封装订单信息
 * @date 2022/11/20 9:28
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @NotEmpty
    private List<Product> products;

    private Long couponId;

    private Long cost;

    @NotNull
    private Long userId;

    /**
     * 目前只支持单张优惠券
     * 但是为了以后的扩展考虑，你可以添加多个优惠券的计算逻辑
     */
    private List<CouponInfo> couponInfos;
}
    
package com.artisan.coupon.calculation.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 商品信息
 * @date 2022/11/20 9:29
 * @mark: show me the code , change the world
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    /**
     * 你可以试着搭建一个商品中心，用来存储商品信息，逐步完善这个应用
     */
    private Long productId;

    /**
     * 商品的价格
     */
    private long price;

    /**
     * 商品在购物车里的数量
     */
    private Integer count;

    /**
     * 商品销售的门店
     */
    private Long shopId;
}
    
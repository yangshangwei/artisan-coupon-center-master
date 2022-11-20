package com.artisan.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


/**
 * @author 小工匠
 * @version 1.0
 * @description: 试算结果
 * @date 2022/11/20 10:25
 * @mark: show me the code , change the world
 */

@Data
@NoArgsConstructor
public class SimulationResponse {

    /**
     * 最省钱的coupon
     */
    private Long bestCouponId;

    /**
     * 每一个coupon对应的order价格
     */
    private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();
}
    
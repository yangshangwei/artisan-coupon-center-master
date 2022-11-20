package com.artisan.coupon.calculation.controller;

import com.alibaba.fastjson.JSON;
import com.artisan.coupon.calculation.api.beans.ShoppingCart;
import com.artisan.coupon.calculation.api.beans.SimulationOrder;
import com.artisan.coupon.calculation.api.beans.SimulationResponse;
import com.artisan.coupon.calculation.service.intf.CouponCalculationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 小工匠
 * @version 1.0
 * @description:
 * @date 2022/11/20 18:09
 * @mark: show me the code , change the world
 */

@Slf4j
@RestController
@RequestMapping("calculator")
public class CouponCalculationController {

    @Autowired
    private CouponCalculationService calculationService;

    /**
     *  优惠券结算
     * @param settlement
     * @return
     */
    @PostMapping("/checkout")
    @ResponseBody
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart settlement) {
        log.info("do calculation: {}", JSON.toJSONString(settlement));
        return calculationService.calculatorOrderPrice(settlement);
    }


    /**
     * 优惠券列表挨个试算
     * 给客户提示每个可用券的优惠额度，帮助挑选
     *
     * @param simulator
     * @return
     */
    @PostMapping("/simulate")
    @ResponseBody
    public SimulationResponse simulate(@RequestBody SimulationOrder simulator) {
        log.info("do simulation: {}", JSON.toJSONString(simulator));
        return calculationService.simulateOrder(simulator);
    }
}
    
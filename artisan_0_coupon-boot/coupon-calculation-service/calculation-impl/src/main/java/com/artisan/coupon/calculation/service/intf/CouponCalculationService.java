package com.artisan.coupon.calculation.service.intf;

import com.artisan.coupon.calculation.api.beans.ShoppingCart;
import com.artisan.coupon.calculation.api.beans.SimulationOrder;
import com.artisan.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author artisan
 */
public interface CouponCalculationService {

    /**
     * 计算订单价格
     * @param shoppingCart
     * @return
     */
    ShoppingCart calculatorOrderPrice(@RequestBody  ShoppingCart shoppingCart);


    /**
     * 模拟计算最优价格
     * @param simulationOrder
     * @return
     */
    SimulationResponse simulateOrder(@RequestBody SimulationOrder simulationOrder);
}

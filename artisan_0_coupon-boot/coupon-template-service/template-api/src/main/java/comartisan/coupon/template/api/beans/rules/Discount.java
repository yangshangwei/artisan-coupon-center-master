package comartisan.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券折扣
 * @date 2022/11/19 18:15
 * @mark: show me the code , change the world
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    /**
     * 满减 - 减掉的签署
     * 折扣 -90 = 9折 ， 95 = 95折扣
     */
    private Long quota;

    /**
     * 最低达到多少消费才能使用
     */
    private Long threshold;
}
    
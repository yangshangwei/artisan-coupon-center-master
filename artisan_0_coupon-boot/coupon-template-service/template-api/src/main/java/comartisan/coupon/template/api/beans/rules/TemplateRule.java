package comartisan.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券规则
 * @date 2022/11/19 18:14
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRule {

    /**
     * 优惠规则
     */
    private Discount discount;

    /**
     * 每个人最多可以领取的数量
     */
    private Integer limitation;

    /**
     * 过期时间
     */
    private Long deadTIme;
}
    
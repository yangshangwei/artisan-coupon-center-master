package comartisan.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券
 * @date 2022/11/19 16:38
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponInfo {

    private Long id;

    /**
     * 模板Id
     */
    private Long templateId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 店铺Id
     */
    private Long shopId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 优惠券模板
     */
    private CouponTemplateInfo couponInfoTemplate;

}
    
package comartisan.coupon.template.api.beans;

import comartisan.coupon.template.api.beans.rules.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 优惠券模板
 * @date 2022/11/19 18:09
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponTemplateInfo {

    private Long id;

    /**
     * 优惠券名称
     */
    @NotNull
    private String name;

    /**
     * 优惠券描述
     */
    @NotNull
    private String desc;

    /**
     * 优惠券类型
     */
    @NotNull
    private String type;

    /**
     * 适用店铺，若无则为通用券
     */
    private Long shopId;

    /**
     * 是否可用
     */
    private Boolean available;

    /**
     * 优惠券规则
     */
    @NotNull
    private TemplateRule rule;

}
    
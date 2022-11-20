package comartisan.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 模板查询（分页）
 * @date 2022/11/19 18:24
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagedCouponTemplateInfo {

    private List<CouponTemplateInfo> templateInfoList;

    private Integer page;

    private Integer total;

}
    
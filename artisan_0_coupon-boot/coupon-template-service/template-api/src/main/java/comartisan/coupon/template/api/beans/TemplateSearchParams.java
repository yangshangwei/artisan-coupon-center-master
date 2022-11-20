package comartisan.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 模板查询（分页）
 * @date 2022/11/19 18:26
 * @mark: show me the code , change the world
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemplateSearchParams {

    private Long id;

    private String name;

    private String type;

    private Long shopId;

    private Boolean available;

    private int page;

    private int pageSize;
}
    
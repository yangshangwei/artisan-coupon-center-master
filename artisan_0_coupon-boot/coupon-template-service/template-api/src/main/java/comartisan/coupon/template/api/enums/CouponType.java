package comartisan.coupon.template.api.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 优惠券枚举类
 *
 * @author artisan
 */
@Getter
@AllArgsConstructor
public enum CouponType {


    UNKNOWN("unknown", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    LONELY_NIGHT_MONEY_OFF("午夜double券", "4"),
    ANTI_PUA("PUA加倍奉还券", "5");


    /**
     * 优惠券描述
     */
    private String description;

    /**
     * 数据库里的Code
     */
    private String code;


    public static CouponType convert(String code) {
        return Stream.of(values())
                .filter(couponType -> couponType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}

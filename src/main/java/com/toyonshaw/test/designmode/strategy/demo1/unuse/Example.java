package com.toyonshaw.test.designmode.strategy.demo1.unuse;

import com.toyonshaw.test.designmode.strategy.demo1.RechargeTypeEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * //Todo 充值例子①网银充值，8.5折； ②商户充值，9折； ③手机充值，没有优惠；④点卡充值，收取1%的渠道费；
 *
 * @author Toyon Shaw
 * @date 2021/11/3
 */
public class Example {

    /**
     * 计算用户充值金额，不同渠道充值优惠活动力度不同
     */
    public Double calculateCharge(Double money, int type) {
        List<Integer> payTypeGroup = Arrays.stream(RechargeTypeEnum.values()).map(RechargeTypeEnum::getType).collect(Collectors.toList());
        if (payTypeGroup.contains(type)) {
            RechargeTypeEnum rechargeTypeEnum = RechargeTypeEnum.getRechargeByType(type);
            if (Objects.nonNull(rechargeTypeEnum)) {
                return  money * rechargeTypeEnum.getDiscount();
            }
        }
        return money;
    }

}

package com.toyonshaw.test.designmode.strategy.demo1.use.impl;

import com.toyonshaw.test.designmode.strategy.demo1.RechargeTypeEnum;
import com.toyonshaw.test.designmode.strategy.demo1.use.DiscountStrategy;

import java.util.Objects;

/**
 * @author Toyon Shaw
 * @date 2021/11/4
 */
public class CardRecharge implements DiscountStrategy {

    @Override
    public Double calculateRecharge(Double money, int type) {
        RechargeTypeEnum rechargeTypeEnum = RechargeTypeEnum.getRechargeByType(type);
        if (Objects.nonNull(rechargeTypeEnum)) {
            return  money * rechargeTypeEnum.getDiscount();
        }
        return money;
    }
}

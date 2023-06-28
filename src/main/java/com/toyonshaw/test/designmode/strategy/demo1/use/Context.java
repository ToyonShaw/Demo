package com.toyonshaw.test.designmode.strategy.demo1.use;

import lombok.Data;

/**
 * @author Toyon Shaw
 * @date 2021/11/4
 */
@Data
public class Context {

    private DiscountStrategy discountStrategy;

    public Double discountRecharge(Double charge, int type) {
        return StrategyFactory.getInstance().creator(type).calculateRecharge(charge,type);
    }

}

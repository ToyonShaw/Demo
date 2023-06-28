package com.toyonshaw.test.designmode.strategy.demo2.use;

import com.toyonshaw.test.designmode.strategy.demo1.use.DiscountStrategy;
import lombok.Data;

/**
 * @author Toyon Shaw
 * @date 2021/11/4
 */
@Data
public class Context2 {

    private DiscountStrategy discountStrategy;

    public Double discountRecharge(Double charge, int type) {
        return StrategyFactory2.getInstance().creator(type).calculateRecharge(charge,type);
    }

}

package com.toyonshaw.test.designmode.strategy.demo1.use;

/**
 * @author Toyon Shaw
 * @date 2021/11/4
 */
public interface DiscountStrategy {

    /**
     * 充值计算
     * @param money 充值金额
     * @param type 支付渠道
     * @return Double 实付金额
     */
     Double calculateRecharge(Double money, int type);

}

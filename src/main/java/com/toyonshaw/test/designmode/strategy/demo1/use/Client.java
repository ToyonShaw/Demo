package com.toyonshaw.test.designmode.strategy.demo1.use;

import com.toyonshaw.test.designmode.strategy.demo1.RechargeTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Toyon Shaw
 * @date 2021/11/4
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        log.info("网银充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.E_BANK.getType()));
        log.info("商户账号充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.BUSI_ACCOUNTS.getType()));
        log.info("手机卡充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.MOBILE.getType()));
        log.info("充值卡充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.CARD_RECHARGER.getType()));
        log.info("微信充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.WE_CHAT.getType()));
        log.info("支付宝充值100, 实付金额：{}", context.discountRecharge(100d, RechargeTypeEnum.ALI_PAY.getType()));


    }

}

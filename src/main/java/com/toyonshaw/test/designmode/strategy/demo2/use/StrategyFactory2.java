package com.toyonshaw.test.designmode.strategy.demo2.use;

import cn.hutool.core.lang.Assert;
import com.toyonshaw.test.designmode.strategy.demo2.RechargeTypeEnum2;
import com.toyonshaw.test.designmode.strategy.demo1.use.DiscountStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 简单工厂-单例懒汉模式
 * @author Toyon Shaw
 * @date 2021/11/4
 */
@Slf4j
public class StrategyFactory2 {

    private static volatile StrategyFactory2 strategyFactory = null;

    private StrategyFactory2() {

    }

    public static StrategyFactory2 getInstance() {
        if (Objects.isNull(strategyFactory)) {
            log.info("strategyFactory is null");
            synchronized (StrategyFactory2.class) {
                log.info("create strategyFactory");
                strategyFactory = new StrategyFactory2();
            }
        }else {
            log.info(" strategyFactory is not null");
        }
        return strategyFactory;
    }

    /*
    private static Map<Integer, DiscountStrategy> strategyMap = new LinkedHashMap<>();

    static {
        strategyMap.put(RechargeTypeEnum.E_BANK.getType(), new EBankPayRecharge());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.getType(), new BusiAccountRecharge());
        strategyMap.put(RechargeTypeEnum.MOBILE.getType(), new MobilePayRecharge());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGER.getType(), new CardRecharge());
        strategyMap.put(RechargeTypeEnum.WE_CHAT.getType(), new WechatPayRecharge());
        strategyMap.put(RechargeTypeEnum.ALI_PAY.getType(), new AliPayRecharge());
    }*/

    public DiscountStrategy creator(int type) {
        RechargeTypeEnum2 rechargeTypeEnum = RechargeTypeEnum2.getRechargeByType(type);
//        "MobilePayRecharge".getClass();
        Assert.notNull(rechargeTypeEnum,"支付类型错误，找不到的支付方式类型：{}", type);
        try {
            Class<?>  cl = Class.forName(rechargeTypeEnum.getPackageName());
            return (DiscountStrategy) cl.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取支付渠道信息异常！", e);
        }
    }


}

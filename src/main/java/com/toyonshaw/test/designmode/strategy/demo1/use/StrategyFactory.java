package com.toyonshaw.test.designmode.strategy.demo1.use;

import com.toyonshaw.test.designmode.strategy.demo1.use.impl.*;
import com.toyonshaw.test.designmode.strategy.demo1.RechargeTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 简单工厂-单例懒汉模式
 * @author Toyon Shaw
 * @date 2021/11/4
 */
@Slf4j
public class StrategyFactory {

    private static volatile StrategyFactory strategyFactory = null;

    private StrategyFactory() {

    }

    public static StrategyFactory getInstance() {
        if (Objects.isNull(strategyFactory)) {
            log.info("strategyFactory is null");
            synchronized (StrategyFactory.class) {
                log.info("create strategyFactory");
                strategyFactory = new StrategyFactory();
            }
        }else {
            log.info(" strategyFactory is not null");
        }
        return strategyFactory;
    }

    private static Map<Integer, DiscountStrategy> strategyMap = new LinkedHashMap<>();

    static {
        strategyMap.put(RechargeTypeEnum.E_BANK.getType(), new EBankPayRecharge());
        strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.getType(), new BusiAccountRecharge());
        strategyMap.put(RechargeTypeEnum.MOBILE.getType(), new MobilePayRecharge());
        strategyMap.put(RechargeTypeEnum.CARD_RECHARGER.getType(), new CardRecharge());
        strategyMap.put(RechargeTypeEnum.WE_CHAT.getType(), new WechatPayRecharge());
        strategyMap.put(RechargeTypeEnum.ALI_PAY.getType(), new AliPayRecharge());
    }

    public DiscountStrategy creator(int type) {
        return strategyMap.get(type);
    }


}

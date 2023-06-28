package com.toyonshaw.test.designmode.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/** 策略模式demo
 * @author Toyon Shaw
 * @date 2021/11/3
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyObjectA());
        context.strategyAchieveWay();
        context.setStrategy(new StrategyObjectB());
        context.strategyAchieveWay();


    }

}

interface Strategy {
    /**
     * 策略方法
     */
    public void strategyWay();
}

/**
 * 具体策略实现方法A
 */
@Slf4j
class StrategyObjectA implements Strategy{
    @Override
    public void strategyWay() {
        log.info("--- StrategyObjectA ---");
    }
}

/**
 * 具体策略实现方法B
 */
@Slf4j
class StrategyObjectB implements Strategy{
    @Override
    public void strategyWay() {
        log.info("--- StrategyObjectB ---");
    }
}

@Data
class Context {
    private Strategy strategy;
    public void strategyAchieveWay() {
        if (Objects.nonNull(strategy)) {
            strategy.strategyWay();
        }
    }
}
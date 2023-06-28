package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @author Toyon Shaw
 * @date 2021/8/6
 */
public class HuaweiFactory implements IProductFactory{
    @Override
    public IMobilePhone phone() {
        return new HuaweiPhone();
    }

    @Override
    public IEarphones earphones() {
        return new HuaweiEarphones();
    }
}

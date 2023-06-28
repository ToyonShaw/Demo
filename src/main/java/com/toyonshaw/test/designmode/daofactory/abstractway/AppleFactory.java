package com.toyonshaw.test.designmode.daofactory.abstractway;

/**
 * @author Toyon Shaw
 * @date 2021/8/6
 */
public class AppleFactory implements IProductFactory, Cloneable{
    @Override
    public IMobilePhone phone() {
        return new AppleMobilePhone();
    }

    @Override
    public IEarphones earphones() {
        return new AppleEarphones();
    }

    @Override
    public AppleFactory clone() {
        try {
            return (AppleFactory) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package com.toyonshaw.test.designmode.strategy.demo2;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Toyon Shaw
 * @date 2021/11/3
 */
@NoArgsConstructor
@AllArgsConstructor
public enum RechargeTypeEnum2 {
    /**
     * 网银
     */
    E_BANK(1,0.95d,"com.toyonshaw.test.strategy.demo1.use.impl.EBankPayRecharge","网银"),
    /**
     * 商户帐号
     */
    BUSI_ACCOUNTS(2,0.90d,"com.toyonshaw.test.strategy.demo1.use.impl.BusiAccountRecharge","商户帐号"),
    /**
     * 手机卡充值
     */
    MOBILE(3,0.98d,"com.toyonshaw.test.strategy.demo1.use.impl.MobilePayRecharge","手机卡充值"),
    /**
     * 充值卡
     */
    CARD_RECHARGER(4,0.95d,"com.toyonshaw.test.strategy.demo1.use.impl.CardRecharge", "充值卡"),
    /**
     * 微信支付
     */
    WE_CHAT(5,0.99d,"com.toyonshaw.test.strategy.demo1.use.impl.WechatPayRecharge", "微信支付"),
    /**
     * 支付宝支付
     */
    ALI_PAY(6,0.99d, "com.toyonshaw.test.strategy.demo1.use.impl.AliPayRecharge","支付宝支付")
    ;


    /**
     * 支付类型
     */
    private int type;
    /**
     * 折扣
     */
    private Double discount;
    /**
     * 对应实现类的包名路径
     */
    private String packageName;

    /**
     * 备注说明
     */
    private String remark;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public static RechargeTypeEnum2 getRechargeByType(int type) {
        List<RechargeTypeEnum2> rechargeGroup = CollUtil.newArrayList(RechargeTypeEnum2.values());
        Optional<RechargeTypeEnum2> optional =rechargeGroup.stream().filter(v-> Objects.equals(v.getType(), type)).findFirst();
        return optional.orElse(null);
    }




}

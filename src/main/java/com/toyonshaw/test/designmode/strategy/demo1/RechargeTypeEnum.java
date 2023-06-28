package com.toyonshaw.test.designmode.strategy.demo1;

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
public enum RechargeTypeEnum {
    /**
     * 网银
     */
    E_BANK(1,0.95d,"网银"),
    /**
     * 商户帐号
     */
    BUSI_ACCOUNTS(2,0.90d,"商户帐号"),
    /**
     * 手机卡充值
     */
    MOBILE(3,0.98d,"手机卡充值"),
    /**
     * 充值卡
     */
    CARD_RECHARGER(4,0.95d, "充值卡"),
    /**
     * 微信支付
     */
    WE_CHAT(5,0.99d, "微信支付"),
    /**
     * 支付宝支付
     */
    ALI_PAY(6,0.99d, "支付宝支付")
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

    public static RechargeTypeEnum getRechargeByType(int type) {
        List<RechargeTypeEnum> rechargeGroup = CollUtil.newArrayList(RechargeTypeEnum.values());
        Optional<RechargeTypeEnum> optional =rechargeGroup.stream().filter(v-> Objects.equals(v.getType(), type)).findFirst();
        return optional.orElse(null);
    }



}

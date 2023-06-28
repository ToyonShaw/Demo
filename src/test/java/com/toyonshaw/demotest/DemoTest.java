package com.toyonshaw.demotest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import com.toyonshaw.test.designmode.strategy.demo1.RechargeTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.ref.WeakReference;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Toyon Shaw
 * @date 2021/11/3
 */
@Slf4j
@SpringBootTest
public class DemoTest {

    public static void main(String[] args) {

//        Long testLong = 1634147013601320977L;
////        String str = String.format("%06d", testLong);


//        log.info("  str: {}", roundToSignificantFigures(testLong, 3));

//        testTryFinally();
        testStringFormat();
        log.info(" ---- test: {} ", 3 << 24);
        log.info(" ---- test2: {} ", 10 << 20);

    }

    public static void testStringFormat() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Duration duration = Duration.between(now, tomorrow);
        long seconds = duration.getSeconds();
        log.info("------------ 距离午夜十二点剩余时间： {}", seconds);
    }


    public static void testTryFinally() {
        try {
            log.info("开始执行.....");
            throw new IllegalStateException("----- test exception ----");
        } finally {
            log.info("执行finally代码");
        }
    }

    public static double roundToSignificantFigures(long num, int n) {
        if(num == 0) {
            return 0;
        }
        final double d = Math.ceil(Math.log10(num < 0 ? -num: num));
        final int power = n - (int) d;
        final double magnitude = Math.pow(10, power);
        final long shifted = Math.round(num*magnitude);
        return shifted/magnitude;
    }

    public static void bubbleSort(int[] sortArray) {
        for (int i = 0; i < sortArray.length - 1; i++) {
            for (int z = 0; z < sortArray.length - 1 - i; z++) {
                if (sortArray[z] > sortArray[z+1]) {
                    int temp = sortArray[z];
                    sortArray[z] = sortArray[z+1];
                    sortArray[z+1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] sortArray) {
        for (int i = 0; i < sortArray.length - 1; i++) {
            int temp = i;
            int min = sortArray[i];
            for (int z = i; z < sortArray.length - 1; z++) {
                if (min>sortArray[z]) {
                    min = z;
                }
            }
            sortArray[temp] = sortArray[i];
            sortArray[i] = min;
        }

    }


    public static int recursionFive(int input) {
        if (input < 0) {
            throw new IllegalStateException("input value must > 0");
        }
        if (input <= 1) {
            return input;
        }
        int result = input*(input -1);
        if (input <=2 ) {
            return result;
        }
        return input*recursionFive(input - 1);
    }



    public void nineNine() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " x " + j + " = " + i*j + "  ");
            }
            System.out.println(" ");
        }

        System.out.println(" ");

        int i = 1;
        while(i <= 9) {
            int j = 1;
            while (j<=i) {
                System.out.print(i + " x " + j + " = " + i*j + "  ");
                j++;
            }
            i++;
            System.out.println(" ");
        }
    }


    /**
     * 弱引用
     */
    public void weakReferenceDemo() {
        WeakReference<Object> weakReference0 = new WeakReference<>(new Object());
        System.out.println(weakReference0.get());
        System.gc();
        System.out.println(weakReference0.get());





    }
    public static String getSceneCertExpirationDate(Integer validityYear, Date setTime) {
        Date now = new Date();
        Date expiresDate = DateUtils.addYears(setTime, validityYear);
        //判断是否是闰年 非02-29的情况需要日期减一天
        if ( !cn.hutool.core.date.DateUtil.format(now, "yyyy-MM-dd").contains("02-29") ) {
            expiresDate = DateUtils.addDays(expiresDate, -1);
        }
        if (now.getTime() > expiresDate.getTime()) {
            expiresDate = DateUtils.addDays(expiresDate, 1);
            return getSceneCertExpirationDate(validityYear, expiresDate);
        }
        return DateUtil.format(setTime, "yyyy-MM-dd") + "至" + DateUtil.format(expiresDate, "yyyy-MM-dd");
    }


    /**
     * 校验证书序号是否已经打印超过90%的数量
     *
     * @param number 当前已打印证书序号
     * @return boolean
     */
    public static boolean checkCerSerialNumberEmergencyInventory(String number) {
        try {
            //触发的百分比
            double triggerPercent = 0.8D;
            int min = 30000;
            int max = 30100;
            int differenceValue = max - min;
            double triggerValue = NumberUtil.mul(triggerPercent, (max - min)) + min;
            log.info("-------- triggerValue={}",triggerValue);
            return Double.parseDouble(number) >= triggerValue;
        } catch (Exception e) {
            log.error("----------- 校验证书序号是否已经打印设定阈值 异常！----------", e);
            return false;
        }
    }


    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
            log.info("result={}", JSONObject.toJSONString(nums));
        }
        log.info("after result={}", JSONObject.toJSONString(nums));
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }


    public static boolean checkCerSerialNumberEmergencyInventory(int number, int max) {
        double compareNumber =   NumberUtil.mul(max, 0.9);
        return (double) number >= compareNumber ;
    }


//    @Test
    public void testAsync() {
        log.info("CARD_RECHARGER: {}", RechargeTypeEnum.CARD_RECHARGER.name());
        String str = EnumUtil.toString(RechargeTypeEnum.BUSI_ACCOUNTS);
        log.info("str: {}", str);
        List<String> names = EnumUtil.getNames(RechargeTypeEnum.class);
        log.info("names: {}", JSONObject.toJSONString(names));

        List<String> fieldNames =  EnumUtil.getFieldNames(RechargeTypeEnum.class);
        log.info("fieldNames: {}", JSONObject.toJSONString(fieldNames));

        List<Object> fieldValues =  EnumUtil.getFieldValues(RechargeTypeEnum.class,"type");
        log.info("fieldValues: {}", JSONObject.toJSONString(fieldValues));

        Map<String, Object> nameFieldMap = EnumUtil.getNameFieldMap(RechargeTypeEnum.class,"type");
        log.info("nameFieldMap: {}", JSONObject.toJSONString(nameFieldMap));
    }

//    @Resource
//    TestRequireNewService TestRequireNewService;

   /* @Test
    public void transactionTest() {
        TestRequireNewService TestRequireNewService = SpringContextUtil.getBean(TestRequireNewService.class);
        TestRequireNewService.test();
    }*/

  /*  @Test
    public void transactionTest() {
        execute("123");
        execute("456");
    }*/


   /* public void execute(String key) {
        while (true) {
            log.info("------------- key: {}", key);
        }
    }*/








}








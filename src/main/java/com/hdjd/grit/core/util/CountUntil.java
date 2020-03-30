package com.hdjd.grit.core.util;

import com.hdjd.grit.model.pojo.Orders;

/**
 * @Author: yuan
 * @Date: 2020/3/22 12:56
 * @Version 1.0
 */
public class CountUntil {
    public static void CountCarriage(Orders orders){
        if (orders.getCarType().equals("大车（13-15方）")){
            Float carriage = 0f;
            if (orders.getDistance() <= 5 && orders.getDistance() > 0){
                carriage = 8.8f;
            }
            if (orders.getDistance() <= 15 && orders.getDistance() > 5){
                carriage = 8.8f + (orders.getDistance() - 5)*1.32f;
            }
            if (orders.getDistance() <= 25 && orders.getDistance() > 15){
                carriage = 8.8f + 13.2f + (orders.getDistance() - 15)*0.7f;
            }
            if (orders.getDistance() > 25){
                carriage = 8.8f + 13.2f + 7f + (orders.getDistance() - 25)*0.53f;
            }
            orders.setCarriage(carriage);
        }
        if (orders.getCarType().equals("小车（6-10方）")){
            Float carriage = 0f;
            if (orders.getDistance() <= 5 && orders.getDistance() > 0){
                carriage = 10f;
            }
            if (orders.getDistance() <= 15 && orders.getDistance() > 5){
                carriage = 10f + (orders.getDistance() - 5)*1.5f;
            }
            if (orders.getDistance() <= 25 && orders.getDistance() > 15){
                carriage = 10f + 15f + (orders.getDistance() - 15)*0.8f;
            }
            if (orders.getDistance() > 25){
                carriage = 10f + 15f + 8f + (orders.getDistance() - 25)*0.6f;
            }
            orders.setCarriage(carriage);
        }
    }

    /**
    public static void main(String[] args) {
        Orders build = Orders.builder().distance(30f).carType("大车（13-15方）").build();
        CountCarriage(build);
        System.out.println(build.getCarType());
        System.out.println(build.getDistance());
        System.out.println(build.getCarriage());
    }
     */
}

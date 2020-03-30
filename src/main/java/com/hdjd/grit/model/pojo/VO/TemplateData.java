package com.hdjd.grit.model.pojo.VO;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:TemplateData
 * @author: yeqi
 * @create: 2020/3/24 10:45
 * @description 设置推送的文字和颜色
 */

@Data
public class TemplateData {
    //keyword1：订单类型，keyword2：下单金额，keyword3：配送地址，keyword4：取件地址，keyword5备注
    private String value;//,,依次排下去

    public TemplateData(String value){
        this.value = value;
    }
//    private String time6; //订单预约时间
//    private String thing4; //订单金额

//    private String date5; //支付时间
//    private String color;//字段颜色（微信官方已废弃，设置没有效果）
}
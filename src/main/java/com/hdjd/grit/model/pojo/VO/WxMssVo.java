package com.hdjd.grit.model.pojo.VO;

import lombok.Data;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:WxMssVo
 * @author: yeqi
 * @create: 2020/3/24 10:43
 * @description 小程序推送所需数据
 */
@Data
public class WxMssVo {
    private String touser;//用户openid
    private String template_id;//模版id
    private String page = "index";//默认跳到小程序首页
    private String form_id;//收集到的用户formid
    private String emphasis_keyword = "keyword1.DATA";//放大那个推送字段
    private Map<String,TemplateData> data;//推送文字
}

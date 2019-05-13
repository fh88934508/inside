package com.huishou.inside.demo.bean;


import lombok.Data;

@Data
public class BeanMachineInstall {

    private  String id;
    private  String step;//步骤
    private  String city;//城市
    private String villages;//乡镇
    private String Community;//社区
    private String area;//区域
    private String site;//站点
    private String token;
    private String remark;//备注
    private  String status;//状态
    private  String latitude;
    private  String longitude;
    private  String installremark;
    private String machine_no;
    private String name;
    private String area4code;//四级编号
    private String version;//版本号
    private String isplcbad;//plc故障
    private String iscamerabad;//摄像头故障
    private String greeting;//是否在线
    private String greeting_time;//上线或离线时间
    private String is_bad;//仓门故障
    private String is_photoreceptor_bad;//光感故障
}

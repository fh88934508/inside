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
}

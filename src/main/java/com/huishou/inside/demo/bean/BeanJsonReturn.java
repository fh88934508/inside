package com.huishou.inside.demo.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class BeanJsonReturn {
    String errcode;
    String errmsg;
    List paramList;
    Map paramMap;
    String id;
}

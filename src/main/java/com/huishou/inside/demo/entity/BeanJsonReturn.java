package com.huishou.inside.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Data
public class BeanJsonReturn {
    String errcode;
    String errmsg;
    List paramList;
    Map paramMap;
    Object data;
    String id;
}

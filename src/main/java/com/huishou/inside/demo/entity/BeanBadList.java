package com.huishou.inside.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BeanBadList {
    String area;
    String no;
    String villages;
    String Community;
    String city;
    String type;
    String site;
    String classify_code;
    String ah_id;
    String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    String upd_time;
    String is_photoreceptor_bad;
    String is_bad;
    String iscamerabad;
    String isplcbad;
}

package com.huishou.inside.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class BeanBadRecode {
    String ah_id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    String crt_time;
    String description;
    String device_id;
    String malfunction_time;
    String status;
}

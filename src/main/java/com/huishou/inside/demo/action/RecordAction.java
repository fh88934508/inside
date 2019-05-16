package com.huishou.inside.demo.action;

import com.huishou.inside.demo.Mapper.HostAttributeMapper;
import com.huishou.inside.demo.bean.BeanBadList;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import com.huishou.inside.demo.bean.host_door_enable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordAction {
    @Autowired BeanJsonReturn  beanJsonReturn;
    @Autowired HostAttributeMapper hostAttributeMapper;
    //主机仓位禁用列表
    @GetMapping("/api/admin/gateenable")
    public BeanJsonReturn getGateEnable(){
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        List<host_door_enable> hostDoorEnable = hostAttributeMapper.getHostDoorEnable();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setErrmsg("读取成功");
        beanJsonReturn.setParamList(hostDoorEnable);

        return beanJsonReturn;
    }
}

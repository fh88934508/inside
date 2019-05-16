package com.huishou.inside.demo.Mapper;


import com.huishou.inside.demo.bean.host_door_enable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostAttributeMapper {
    @Select("select * from host_door_enable")
    List<host_door_enable> getHostDoorEnable();
}

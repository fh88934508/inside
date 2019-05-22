package com.huishou.inside.demo.mapper;


import com.huishou.inside.demo.entity.host_door_enable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HostAttributeMapper {
    @Select("select * from host_door_enable")
    List<host_door_enable> getHostDoorEnable();
}

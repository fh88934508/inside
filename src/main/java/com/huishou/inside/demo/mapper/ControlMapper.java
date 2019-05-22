package com.huishou.inside.demo.mapper;

import com.huishou.inside.demo.entity.BeanMachineInstall;
import com.huishou.inside.demo.entity.m_version;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ControlMapper {
    @Select("select * from m_install_record t where t.id=#{id}")
    public BeanMachineInstall getRegisterHostinfo(@Param("id") String id);
    @Select("select * from (select * from m_version   ORDER BY up_time desc) t LIMIT 1")
    public m_version getVersion();
}

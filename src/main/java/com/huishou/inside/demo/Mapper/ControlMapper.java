package com.huishou.inside.demo.Mapper;

import com.huishou.inside.demo.bean.BeanMachineInstall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ControlMapper {
    @Select("select * from m_install_record t where t.id=#{id}")
    public BeanMachineInstall getRegisterHostinfo(@Param("id") String id);
}

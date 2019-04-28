package com.huishou.inside.demo.Mapper;

import com.huishou.inside.demo.bean.BeanMachineInstall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MapMapper {
    @Select("select * from m_install_record")
    public List<BeanMachineInstall> getMapAll();
}

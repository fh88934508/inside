package com.huishou.inside.demo.mapper;

import com.huishou.inside.demo.entity.BeanMachineInstall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MapMapper {

    @Select("select * from m_install_record t \n" +
            "left join dbs_android_host t1 on t1.id=t.machine_no \n" +
            "left join (select t.ah_id,t.is_bad,t.is_photoreceptor_bad from dbs_device t where (t.is_bad='true' or t.is_photoreceptor_bad='true') and t.is_enable=1 GROUP BY t.ah_id) t2 on t2.ah_id=t.machine_no\n" +
            "where t.is_cancellation=1  ")
    public List<BeanMachineInstall> getMapAll();

}

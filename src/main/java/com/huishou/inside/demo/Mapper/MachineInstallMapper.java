package com.huishou.inside.demo.Mapper;

import com.huishou.inside.demo.bean.BeanMachineInstall;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface MachineInstallMapper {
    @Insert("insert into m_install_record (id,step,city,villages,Community,select_date,status,select_remark,order_no) VALUES (#{id},2,#{city},#{villages},#{Community},now(),'正常',#{remark},(select concat('MI',year(now()),MONTH(now()),extract(day_second from now()))))")
    void addSelect(BeanMachineInstall beanMachineInstall);
    @Select("select t.city as title,CAST(count(1) AS CHAR) as count from m_install_record t where t.step=#{current} GROUP by t.city")
    List<Map<String,String>> getTitleListStep0(Integer current);
    @Select("select t.villages as title,CAST(count(1) AS CHAR) as count from m_install_record t where t.step=#{current} and t.city=#{city} ")
    List<Map<String,String>> getTitleListStep1(Integer current,String city);
    @Select("select t.Community as title,CAST(count(1) AS CHAR) as count from m_install_record t where t.step=#{current} and t.city=#{city} and t.villages=#{villages}")
    List<Map<String,String>> getTitleListStep2(Integer current,String city,String villages);
    @Select("select t.order_no as title,'1' as count from m_install_record t where t.step=#{current} and t.city=#{city} and t.villages=#{villages} and t.Community=#{Community} ")
    List<Map<String,String>> getTitleListStep3(Integer current,String city,String villages,String Community);
    @Select("select t.id,t.city,t.villages,t.Community,t.order_no,DATE_FORMAT(t.select_date,'%Y-%m-%d %H:%i:%s') as select_date ,t.select_remark from m_install_record t where t.id=#{id}")
    Map<String,String> getSelectVerify(String id);
    @Update("update m_install_record t set t.step=#{step}, t.select_v_date=now(),t.terrace_progress=#{terrace_progress},t.select_v_remark=#{remark},t.latitude=#{latitude},t.longitude=#{longitude} where t.id=#{id}")
    void updateSelectVerify(String id,String remark,String step,String latitude,String longitude,String terrace_progress);

    @Update("update m_install_record t set t.step=0,t.cancellation_date=now(),t.cancellation_remark=#{remark} where t.id=#{id}")
    void cancellation(String id,String remark);

    @Select("select t.id,t.city,t.villages,t.terrace_remark,t.terrace_progress,t.Community,t.step,t.terrace_progress,t.order_no,DATE_FORMAT(t.select_v_date,'%Y-%m-%d %H:%i:%s') as select_v_date ,t.select_v_remark,t.terrace_progress,t.longitude,t.latitude from m_install_record t where t.id=#{id}")
    Map<String,String> getterrace(String id);
    @Select("select t.id,t.step,t.select_date,t.select_v_date,\n" +
            "t.terrace_date,t.installation_date,t.dabug_date  \n" +
            "from m_install_record t where t.order_no=#{orderno}")
    Map<String,String> getorder(String orderno);
    @Select("select * from m_install_record t where t.order_no=#{orderno}")
    Map<String, String> getdtail(String orderno);
    @Update("UPDATE m_install_record t set t.step=5,t.debug_progress='完成',t.debug_remark=#{remark},t.machine_no=#{machineno},t.dabug_date=NOW() where t.id=#{id}")
    void updatedebug(String id, String remark, String machineno);
    @Update("UPDATE m_install_record t set t.step=6,t.installation_progress='完成',t.installation_remark=#{remark},t.installation_date=NOW() where t.id=#{id}")
    void updateinstall(String id, String remark);
    @Update("UPDATE m_install_record t set t.step=#{step},t.terrace_progress=#{terracestep},t.terrace_remark=#{remark},t.terrace_date=NOW() where t.id=#{id}")
    void updateterrace(String id, String terracestep, String remark, String step);
}
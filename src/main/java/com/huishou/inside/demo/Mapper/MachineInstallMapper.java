package com.huishou.inside.demo.Mapper;
import com.huishou.inside.demo.bean.BeanMachineInstall;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
@Mapper
public interface MachineInstallMapper {
    @Insert("insert into m_install_record (id,step,city,villages,Community,area,site,select_date,status,select_remark,order_no) VALUES (#{id},2,#{city},#{villages},#{Community},#{area},#{site},now(),'正常',#{remark},(select concat('MI',year(now()),MONTH(now()),extract(day_second from now()))))")
    void addSelect(BeanMachineInstall beanMachineInstall);
    @Select("select DISTINCT t.site as title  from m_install_record t where t.step=#{current} ")
    List<Map<String,String>> getTitleListStep0(Integer current);
    @Select("select t.order_no as title from m_install_record t where t.step=#{current} and t.site=#{site} ")
    List<Map<String,String>> getTitleListStep1(@Param("current")Integer current,@Param("site") String site);
//    @Select("select t.Community as title,CAST(count(1) AS CHAR) as count from m_install_record t where t.step=#{current} and t.city=#{city} and t.villages=#{villages}")
//    List<Map<String,String>> getTitleListStep2(Integer current,String city,String villages);
//    @Select("select t.order_no as title,'1' as count from m_install_record t where t.step=#{current} and t.city=#{city} and t.villages=#{villages} and t.Community=#{Community} ")
//    List<Map<String,String>> getTitleListStep3(Integer current,String city,String villages,String Community);
//    @Select("select t.order_no as title,'1' as count from m_install_record t where t.step=#{current}")
//    List<Map<String,String>> getTitleListStep(Integer current);55
    @Select("select t.id,t.city,t.villages,t.Community,t.order_no,DATE_FORMAT(t.select_date,'%Y-%m-%d %H:%i:%s') as select_date ,t.select_remark from m_install_record t where t.id=#{id}")
    Map<String,String> getSelectVerify(String id);
    @Update("update m_install_record t set t.step=#{step}, t.select_v_date=now(),t.terrace_progress=#{terrace_progress},t.select_v_remark=#{remark},t.latitude=#{latitude},t.longitude=#{longitude} where t.id=#{id}")
    void updateSelectVerify(@Param("id")String id,@Param("remark")String remark,@Param("step")String step,
                            @Param("latitude")String latitude,@Param("longitude")String longitude,@Param("terrace_progress")String terrace_progress);
    @Update("update m_install_record t set t.step=0,t.cancellation_date=now(),t.cancellation_remark=#{remark} where t.id=#{id}")
    void cancellation(@Param("id")String id,@Param("remark")String remark);
    @Select("select t.id,t.city,t.villages,t.terrace_remark,t.terrace_progress,t.Community,t.step,t.terrace_progress,t.order_no,DATE_FORMAT(t.select_v_date,'%Y-%m-%d %H:%i:%s') as select_v_date ,t.select_v_remark,t.terrace_progress,t.longitude,t.latitude from m_install_record t where t.id=#{id}")
    Map<String,String> getterrace(String id);
    @Select("select t.id,t.step,t.select_date,t.select_v_date,\n" +
            "t.terrace_date,t.installation_date,t.dabug_date  \n" +
            "from m_install_record t where t.order_no=#{orderno}")
    Map<String,String> getorder(String orderno);
    @Select("select * from m_install_record t where t.order_no=#{orderno}")
    Map<String, String> getdtail(String orderno);
    @Update("UPDATE m_install_record t set t.step=6,t.debug_progress='完成',t.debug_remark=#{remark},t.dabug_date=NOW() where t.id=#{id}")
    void updatedebug(@Param("id")String id, @Param("remark")String remark);
    @Update("UPDATE m_install_record t set t.step=5,t.installation_progress='完成',t.machine_no=#{machineno},t.installation_remark=#{remark},t.installation_date=NOW() where t.id=#{id}")
    void updateinstall( @Param("id")String id, @Param("remark")String remark,@Param("machineno")String machineno);
    @Update("UPDATE m_install_record t set t.step=#{step},t.terrace_progress=#{terracestep},t.terrace_remark=#{remark},t.terrace_date=NOW() where t.id=#{id}")
    void updateterrace(@Param("id")String id, @Param("terracestep")String terracestep,@Param("remark") String remark, @Param("step")String step);
    @Update("UPDATE m_install_record t set t.step=3,t.terrace_progress=#{terrace_progress},t.terrace_date=NOW() where t.id=#{id}")
    void updateRepair(@Param("id")String id, @Param("terrace_progress")String terrace_progress);
    @Select("SELECT t.step AS title,count(1) as count FROM m_install_record  t GROUP BY t.step")
    List<Map<String,Object>> getStepCount();
    @Insert("insert into m_install_record (id,step,city,villages,Community,area,site,select_date,status,select_remark,order_no,latitude,longitude) VALUES (#{id},4,#{city},#{villages},#{Community},#{area},#{site},now(),'正常',#{remark},(select concat('MI',year(now()),MONTH(now()),extract(day_second from now()))),#{latitude},#{longitude})")
    void new2m_select(BeanMachineInstall beanMachineInstall);
    @Update("UPDATE m_install_record t set t.step=6,t.installation_progress='完成',t.machine_no=#{machineno},t.installation_remark=#{remark},t.installation_date=NOW() where t.id=#{id}")
    void new2m_install( @Param("id")String id, @Param("remark")String remark,@Param("machineno")String machineno);
    @Select("select concat(t.city,'-',t.villages,'-',t.area,'-',t.Community,'-',t.site)  as title,t.order_no as order_no  from m_install_record t where t.step=4")
    List<Map<String,String>> new2m_title1();
    @Select("select concat(t.city,'-',t.villages,'-',t.area,'-',t.Community,'-',t.site)  as title,t.order_no as order_no  from m_install_record t where t.step=6")
    List<Map<String,String>> new2m_title2();
    @Update("update m_install_record t set t.machine_no=#{machine_no},t.city=#{city},t.villages=#{villages},t.area=#{area},t.Community=#{Community},t.site=#{site},t.latitude=#{latitude},t.longitude=#{longitude},t.select_remark=#{remark},t.installation_remark=#{installremark} where t.id=#{id}")
    void new2m_modify(BeanMachineInstall beanMachineInstall);
    @Select("select * from m_install_record t where t.id=#{id}")
    Map<String, String> get2versiondetail(String id);
}

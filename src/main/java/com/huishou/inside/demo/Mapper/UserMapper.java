package com.huishou.inside.demo.Mapper;
import com.huishou.inside.demo.bean.BeanMachineInstall;
import com.huishou.inside.demo.bean.BeanUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
   @Insert("INSERT into user_info (id,name,openid) VALUES (UUID(),#{name},#{openid})")
    public void insertNameOpenid(BeanUser beanUser);
   @Select("select * from user_info")
    public List<Map<String,String>> getAll();
   @Update("UPDATE user_info t set t.openid=\"123123\" and t.name=\"7777\" where t.id=\"1\"")
    public void update(BeanUser beanUser);
    @Select("select * from user_info where openid=#{openid}")
    Map<String, String> getbyopenid(String openid);
}

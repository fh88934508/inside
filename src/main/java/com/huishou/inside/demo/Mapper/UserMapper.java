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
   @Update("UPDATE user_info t set t.name=#{name} where t.openid=#{openid}")
    public void update(BeanUser beanUser);
    @Select("select * from user_info where openid=#{openid}")
    Map<String, String> getbyopenid(String openid);
    @Select("SELECT\n" +
            "t.id,\n" +
            "t.userid,\n" +
            "t.username,\n" +
            "t.`password`,\n" +
            "t.phone,\n" +
            "t.openid,\n" +
            "t.`name`,\n" +
            "t1.role,\n" +
            "t1.user_id\n" +
            "FROM\n" +
            "user_info AS t\n" +
            "LEFT JOIN user_group AS t1 ON t1.user_id = t.id\n" +
            "WHERE\n" +
            "t.username = #{username}")
    BeanUser getUser(String username);
}

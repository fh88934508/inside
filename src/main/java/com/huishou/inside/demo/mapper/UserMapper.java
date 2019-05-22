package com.huishou.inside.demo.mapper;

import com.huishou.inside.demo.entity.BeanUser;
import com.huishou.inside.demo.entity.User;
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
    @Select("select * from user_info where username=#{Username}")
    BeanUser getUser(String username);
    @Insert("INSERT into user_info (id,username,password,role,name) values (UUID(),#{username},#{password},#{role},#{name})")
    public void save(User user);
    @Select("select * from user_info where username=#{Username}")
    public User findByUsername(String Username);
    @Update("update user_info set password=#{password} where  username=#{username}")
    void updatePassword(User user);
}

package pers.se.mapper;

import pers.se.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.lettuce.core.dynamic.annotation.Param;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

// @Mapper
public interface UserMapper extends BaseMapper<User> {
    // @Select("select * from sys_user")
    // List<User> findAll();

    // @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
    // int insert(User user);

    // int update(User user);

    // @Delete("delete from sys_user where id = #{id}")
    // Integer deleteById(@Param("id") Integer id);

    // @Select("select * from sys_user where username like #{username} limit #{pageNum}, #{pageSize}")
    // List<User> selectPage(Integer pageNum, Integer pageSize, String username);
    
    // @Select("select count(*) from sys_user where username like #{username}")
    // Integer selectTotal(String username);
}
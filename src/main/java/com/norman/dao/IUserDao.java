package com.norman.dao;

import com.norman.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 多表一对多
 * 在mybatis中针对,CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)//开启二级缓存
public interface IUserDao {

    /**
     * 查询所有用户
     * "@Result"：声明别名注解，column = 数据库，property = 实体类属性，id=true声明主键,
     * "  @Results(id="userMap""声明，可以给其他方法用
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            // @Many对多；FetchType.LAZY延迟加载，对多用
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.norman.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    @ResultMap(value = {"userMap"})//引用方式1
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")//引用方式1
    List<User> findUserByName(String username);


}

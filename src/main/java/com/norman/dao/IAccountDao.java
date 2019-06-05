package com.norman.dao;

import com.norman.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * 多表一对一
     *
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            //FetchType.EAGER》》立即加载 对一用
            //FetchType.LAZY》》延迟加载  对二用
            //FetchType.DEFAULT 》》
            //one=@One》》对一
            @Result(property = "user",column = "uid",one=@One(select="com.norman.dao.IUserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);
}

package com.jim.microservice.dao;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jim.microservice.entity.User;

/**
 * 用户表(User)表数据库访问层
 *
 * @author jimliu
 * @since 2022-05-26 17:53:58
 */
@DS("userCenter")
public interface UserDao extends BaseMapper<User> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * 查询全部用户
     * @return
     */
    List<User> selectAll();

    /**
     * 分页查询用户
     * @return
     */
    List<User> selectPage();

}


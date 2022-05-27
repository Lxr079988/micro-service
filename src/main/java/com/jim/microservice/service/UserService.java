package com.jim.microservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.jim.microservice.entity.User;
import com.jim.microservice.vo.PageRequest;
import com.jim.microservice.vo.PageResult;
import com.jim.microservice.vo.WebRequest;
import com.jim.microservice.vo.WebResponse;

/**
 * 用户表(User)表服务接口
 *
 * @author jimliu
 * @since 2022-05-26 17:53:58
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    WebResponse<PageResult> findPage(WebRequest<PageRequest> pageRequest);

    PageInfo<User> getPageInfo(PageRequest request);
}


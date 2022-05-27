package com.jim.microservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.jim.microservice.dao.UserDao;
import com.jim.microservice.entity.User;
import com.jim.microservice.service.UserService;
import com.jim.microservice.vo.PageRequest;
import com.jim.microservice.vo.PageResult;
import com.jim.microservice.vo.WebRequest;
import com.jim.microservice.vo.WebResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author jimliu
 * @since 2022-05-26 17:53:58
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 获取用户分页
     * api描述
     * @param
     * @return
     */
    @PostMapping("getUserByPage")
    public WebResponse<PageResult> getUserByPage(@RequestBody @Valid WebRequest<PageRequest> request){
        return userService.findPage(request);
    }
}


package com.jim.microservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jim.microservice.dao.UserDao;
import com.jim.microservice.entity.User;
import com.jim.microservice.service.UserService;
import com.jim.microservice.until.PageUtils;
import com.jim.microservice.vo.PageRequest;
import com.jim.microservice.vo.PageResult;
import com.jim.microservice.vo.WebRequest;
import com.jim.microservice.vo.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author jimliu
 * @since 2022-05-26 17:53:58
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public WebResponse<PageResult> findPage(WebRequest<PageRequest> request) {
        return request.genSuccessResp(PageUtils.getPageResult(request.getData(), getPageInfo(request.getData())));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    public PageInfo<User> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        // 分页的核心就一行代码， PageHelper.startPage(page,pageSize); 这个就表示开始分页。
        // 加了这个之后pagehelper 插件就会通过其内部的拦截器，将执行的sql语句，转化为分页的sql语句。
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userDao.selectPage();
        return new PageInfo<User>(sysMenus);
    }
}


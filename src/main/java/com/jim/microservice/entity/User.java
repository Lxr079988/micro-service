package com.jim.microservice.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 用户表(User)表实体类
 *
 * @author jimliu
 * @since 2022-05-26 17:53:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = -84105844255704414L;

    private Long id;
    //用户唯一标识
    private String userId;
    //用户名
    private String userName;
    //中文名
    private String userNameCn;
    //英文名
    private String userNameEn;
    //用户邮箱
    private String userEmail;
    //部门唯一标识
    private String departmentId;
    //部门名称
    private String departmentName;
    //职位名称
    private String positionName;
    //上次登录时间
    private Date lastLoginTime;
    //是否正常   0否  1是
    private Long status;
    //更新人唯一标识
    private String updateUserId;
    //创建人唯一标识
    private String createUserId;

    private Date updateTime;

    private Date createTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}


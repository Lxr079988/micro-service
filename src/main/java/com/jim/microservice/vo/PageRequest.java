package com.jim.microservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Classname PageRequest
 * @Description 分页请求类
 * @Date 2022/5/27 13:43
 * @Created by Jimliu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    /**
     * 当前页码
     */
    @NotNull(message = "当前页码不能为空！")
    private Integer pageNum;

    /**
     * 每页数量
     */
    @NotNull(message = "每页数量不能为空！")
    private Integer pageSize;
}

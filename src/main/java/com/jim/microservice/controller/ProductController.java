package com.jim.microservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jim.microservice.entity.Product;
import com.jim.microservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 产品表(Product)表控制层
 *
 * @author jimliu
 * @since 2022-05-25 18:34:33
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;
}


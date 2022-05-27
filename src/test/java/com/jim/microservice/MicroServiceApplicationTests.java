package com.jim.microservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jim.microservice.entity.Product;
import com.jim.microservice.service.ProductService;
import com.jim.microservice.service.UserService;
import com.jim.microservice.vo.PageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroServiceApplicationTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        System.out.println(userService.list());
    }

}

package com.jim.microservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.microservice.dao.ProductDao;
import com.jim.microservice.entity.Product;
import com.jim.microservice.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * 产品表(Product)表服务实现类
 *
 * @author jimliu
 * @since 2022-05-25 18:34:34
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}


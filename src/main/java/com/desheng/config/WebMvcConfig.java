package com.desheng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置图片访问路径虚拟化
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${file.uploadPath}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 本地文件上传路径  并映射 同过地址加/profile/* 进行访问 如：localhost:80/profile/数据库路径地址**/
        registry.addResourceHandler("/profile/**").addResourceLocations("file:" + uploadPath + "/");
    }
}

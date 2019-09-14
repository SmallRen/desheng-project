package com.desheng.launch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


/**
 * spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement 开启事务支持后，
 * 然后在访问数据库的Service方法上添加注解 @Transactional 便可
 * <p>
 * 一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值。
 *
 * @EnableAutoConfiguration 开启自动配置
 * @ComponentScan(basePackages = )扫描 Bean 的规则，比如扫描哪些包。com.layui.quartz
 */
@SpringBootApplication(scanBasePackages = "com.desheng", exclude = {
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@MapperScan(value = "com.desheng.mapper")
public class RunDsApplication {

    @Bean
    public RestTemplate restTemplate() {
        // 默认请求用的是jdk自带的HttpURLConnection，也可以使用第三方httpclient,okhttp，需要引入jar包;
        // return new RestTemplate();
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    // @Bean
   /* public LogAspect logAspect() {
        return new LogAspect();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(RunDsApplication.class, args);
    }
}


package com.supergenius.admin;

import com.supergenius.admin.config.CacheConfig;
import com.supergenius.admin.config.DataSourceConfig;
import com.supergenius.admin.config.SwaggerConfig;
import com.supergenius.admin.config.WebConfig;
import com.supergenius.admin.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zuoyu
 */
@EnableSwagger2
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
@Import(value = {CacheConfig.class, SwaggerConfig.class, WebConfig.class, SecurityConfig.class, DataSourceConfig.class})
public class  ProjSupergeniusVcAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjSupergeniusVcAdminApplication.class, args);
    }

}

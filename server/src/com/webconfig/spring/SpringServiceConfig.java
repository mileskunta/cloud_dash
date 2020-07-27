package com.webconfig.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2017/6/6.
 */
@Configuration
@ComponentScan(basePackages = {"com.ezhupai.service"})
@Import(SpringJpaPersistenceConfig.class)
public class SpringServiceConfig {
}

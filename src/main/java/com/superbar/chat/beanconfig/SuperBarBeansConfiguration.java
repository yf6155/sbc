package com.superbar.chat.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * <p>Application Name : SuperBarBeansConfiguration </p>
 * <p>Application Description : SpringBeans 统一配置类 </p>
 * <p>Company : SuperBar </p>
 * (C) Copyright SuperBar Corporation 2019 All Rights Reserved.
 *
 * @Auther : HandsGoing
 * @Date : 2019/11/30
 * @Version : v1.0
 */
@Configuration
public class SuperBarBeansConfiguration {

    @Bean
    public TaskScheduler taskScheduler() {
        TaskScheduler scheduler = new ThreadPoolTaskScheduler();
        return scheduler;
    }

}

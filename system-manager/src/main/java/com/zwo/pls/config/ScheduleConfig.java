package com.zwo.pls.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Create by Yuanquan.Liu in 2019-02
 */
@Configuration
@EnableScheduling // 计划任务，prod 需要开启，用于钉钉考勤录入
@Profile({"test"})
public class ScheduleConfig {

}

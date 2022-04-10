package com.xiaowangzi.yygh.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xiaowangzi.yygh.user.mapper")
public class UserConfig {
}

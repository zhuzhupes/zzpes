package com.xiaozhu.zzpes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@SpringBootApplication
public class ZzpesApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ZzpesApplication.class);

        // TODO: 设置参数
        application.setBannerMode(Banner.Mode.CONSOLE);

        application.run(args);
    }
}

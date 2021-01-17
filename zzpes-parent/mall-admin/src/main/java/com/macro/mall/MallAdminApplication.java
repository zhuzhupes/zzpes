package com.macro.mall;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;;


/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@SpringBootApplication
@ComponentScan({"com.xiaozhu.zzpes","com.macro.mall"})
public class MallAdminApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MallAdminApplication.class);

        // TODO: 设置参数
        application.setBannerMode(Banner.Mode.CONSOLE);

        application.run(args);
    }
}

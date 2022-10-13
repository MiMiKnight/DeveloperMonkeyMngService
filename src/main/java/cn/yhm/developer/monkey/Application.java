package cn.yhm.developer.monkey;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-11 00:10:10
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.yhm.developer.monkey", "cn.yhm.developer.ecology"})
public class Application {

    private static final String APP_NAME = "DeveloperMonkeyMngService";

    public static void main(String[] args) {
        // 启动项目
        SpringApplication.run(Application.class, args);
        log.info("The project " + APP_NAME + " started successfully.");
    }
}

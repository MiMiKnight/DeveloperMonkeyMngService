package cn.yhm.developer.monkey;

import cn.yhm.developer.ecology.core.App;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 启动程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-11 00:10:10
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"cn.yhm.developer.monkey", "cn.yhm.developer.ecology"})
public class Application {
    public static void main(String[] args) {
        // 启动项目
        App.run(Application.class, args);
    }
}

package cn.yhm.developer.monkey.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * MyBatis-Plus配置类
 * <p>
 * EnableTransactionManagement 开启事务支持
 * <p>
 * MapperScan mapper类扫描
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-07 19:33:18
 */
@MapperScan(basePackages = {"cn.yhm.developer.monkey.mapper"})
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusPageInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MARIADB));
        // 乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 防全表更新与删除插件
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                // 插入创建时间
                this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
                // 插入更新时间
                this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                // 更新时 更新"更新时间"
                this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
            }
        };
    }
}

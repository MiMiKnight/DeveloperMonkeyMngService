package cn.yhm.developer.monkey.common.constant;

import cn.yhm.developer.ecology.common.constant.EcologyExceptionCode;

/**
 * 异常代码
 * <p>
 * 业务代码：
 * <p>
 * AA：04
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-15 20:10:27
 */
public interface ExceptionCode extends EcologyExceptionCode {

    /**
     * 业务模块：AA：04
     */
    interface Service {

        /**
         * 公共模块 BB：00 CCC：xxx
         */
        interface Common {
            /**
             * 主键ID不能为空
             * <p>
             * HD.0400001
             */
            String PRIMARY_KEY_CANNOT_BE_NULL = "HD.0400001";

            /**
             * 方法参数不能为null
             * <p>
             * HD.0400002
             */
            String PARAMETER_CANNOT_BE_NULL = "HD.0400002";

            /**
             * 乐观锁参数不能为null
             * <p>
             * HD.0400003
             */
            String VERSION_CANNOT_BE_NULL = "HD.0400003";

            /**
             * 创建时间参数不能为null
             * <p>
             * HD.0400004
             */
            String CREATETIME_CANNOT_BE_NULL = "HD.0400004";

            /**
             * 更新时间参数不能为null
             * <p>
             * HD.0400005
             */
            String UPDATETIME_CANNOT_BE_NULL = "HD.0400005";
        }

        /**
         * Content模块 BB：01 CCC：xxx
         */
        interface Content {

            /**
             * 主键ID无效，无法根据主键ID查到数据
             */
            String PRIMARY_KEY_IS_INVALID = "HD.0401000";

        }
    }

}

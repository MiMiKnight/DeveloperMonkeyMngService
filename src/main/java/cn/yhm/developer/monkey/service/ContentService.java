package cn.yhm.developer.monkey.service;

import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.monkey.model.entity.ContentEntity;

/**
 * Content服务类接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 22:55:04
 */
public interface ContentService {

    /**
     * 根据主键ID查询Content实体类对象
     *
     * @param id 主键
     * @return Content实体类对象
     * @throws EcologyException 自定义异常
     */
    ContentEntity selectById(String id) throws EcologyException;

}

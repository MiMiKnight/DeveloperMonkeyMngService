package cn.yhm.developer.monkey.service;

import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Content服务类接口
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 22:55:04
 */
public interface ContentService extends IService<ContentEntity> {

    /**
     * 无条件分页查询
     *
     * @param offset   偏移量
     * @param pageSize 每页记录数
     * @return {@link List}<{@link ContentEntity}>
     */
    List<ContentEntity> getContentByPage(Long offset, Long pageSize);
}

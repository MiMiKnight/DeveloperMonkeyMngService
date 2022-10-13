package cn.yhm.developer.monkey.mapper;

import cn.yhm.developer.monkey.model.entity.ContentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 内容Mapper
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-06 00:28:29
 */
@Repository
public interface ContentMapper {

    /**
     * 根据主键ID查询Content实体类对象
     *
     * @param id 主键
     * @return Content实体类对象
     */
    ContentEntity selectById(@Param("id") String id);
}

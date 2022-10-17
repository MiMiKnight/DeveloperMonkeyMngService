package cn.yhm.developer.monkey.mapper;

import cn.yhm.developer.monkey.model.entity.ContentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容Mapper
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-06 00:28:29
 */
@Repository
public interface ContentMapper extends BaseMapper<ContentEntity> {

    /**
     * 无条件分页查询
     *
     * @param offset   偏移量
     * @param pageSize 每页记录数
     * @return {@link List}<{@link ContentEntity}> 结果集
     */
    List<ContentEntity> getContentByPage(@Param("offset") Long offset, @Param("pageSize") Long pageSize);
}

package cn.yhm.developer.monkey.service.impl;

import cn.yhm.developer.monkey.mapper.ContentMapper;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 内Content服务类的实现类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 22:56:20
 */
@Slf4j
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, ContentEntity> implements ContentService {

    @Resource
    private ContentMapper contentMapper;


    @Override
    public List<ContentEntity> getContentByPage(Long offset, Long pageSize) {
        if (null == offset || null == pageSize || pageSize < 1L) {
            throw new IllegalArgumentException();
        }
        return contentMapper.getContentByPage(offset,pageSize);
    }
}

package cn.yhm.developer.monkey.service.impl;

import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.monkey.mapper.ContentMapper;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 内Content服务类的实现类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 22:56:20
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Resource
    private ContentMapper contentMapper;

    @Override
    public ContentEntity selectById(String id) throws EcologyException {
        if (StringUtils.isEmpty(id)) {
            throw new EcologyException("111", "Primary key cannot be empty");
        }
        return contentMapper.selectById(id);
    }
}

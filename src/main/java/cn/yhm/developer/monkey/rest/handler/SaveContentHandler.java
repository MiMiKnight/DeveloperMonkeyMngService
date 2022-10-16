package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.common.constant.AspectOrder;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.SaveContentRequest;
import cn.yhm.developer.monkey.model.response.SaveContentResponse;
import cn.yhm.developer.monkey.service.ContentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 保存内容处理程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-15 11:31:55
 */
@Transactional(rollbackFor = Exception.class)
@Component
public class SaveContentHandler implements GatewayHandler<SaveContentRequest, SaveContentResponse> {

    @Resource
    private ContentService contentService;

    @Override
    public SaveContentResponse handle(SaveContentRequest request) throws Exception {
        String content = request.getContent();
        ContentEntity entity = new ContentEntity().setContent(content);
        contentService.save(entity);
        return SaveContentResponse.builder().build();
    }
}

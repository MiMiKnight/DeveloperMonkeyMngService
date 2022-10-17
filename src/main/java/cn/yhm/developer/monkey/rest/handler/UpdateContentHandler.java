package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.common.constant.ExceptionCode;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.UpdateContentRequest;
import cn.yhm.developer.monkey.model.response.UpdateContentResponse;
import cn.yhm.developer.monkey.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 更新内容处理程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-15 15:08:48
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Component
public class UpdateContentHandler implements GatewayHandler<UpdateContentRequest, UpdateContentResponse> {

    private interface ExceptionMessage {
        String MSG_001 = "The primary key is invalid";
    }

    @Resource
    private ContentService contentService;

    @Override
    public UpdateContentResponse handle(UpdateContentRequest request) throws Exception {
        String content = request.getContent();
        String id = request.getId();
        ContentEntity entity = contentService.getById(id);
        if (null == entity) {
            log.error(ExceptionMessage.MSG_001);
            throw new EcologyException(ExceptionCode.Service.Content.PRIMARY_KEY_IS_INVALID, ExceptionMessage.MSG_001);
        }
        ContentEntity contentEntity =
                new ContentEntity().setId(id)
                        .setContent(content)
                        .setVersion(entity.getVersion() + 1);
        contentService.updateById(contentEntity);
        return UpdateContentResponse.builder().build();
    }
}

package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.GetContentByIdRequest;
import cn.yhm.developer.monkey.model.response.GetContentByIdResponse;
import cn.yhm.developer.monkey.service.ContentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 审计内容处理程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-11 07:30:45
 */
@Transactional(rollbackFor = Exception.class)
@Component
public class GetContentByIdHandler implements GatewayHandler<GetContentByIdRequest, GetContentByIdResponse> {

    @Resource
    private ContentService contentService;

    @Override
    public GetContentByIdResponse handle(GetContentByIdRequest request) throws Exception {
        Long cid = request.getCid();
        ContentEntity content = contentService.getById(cid);
        return GetContentByIdResponse.builder().id(content.getId()).content(content.getContent()).deleted(content.getDeleted()).createTime(content.getCreateTime()).updateTime(content.getUpdateTime()).build();
    }
}
package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.GetContentByIdRequest;
import cn.yhm.developer.monkey.model.response.GetContentByIdResponse;
import cn.yhm.developer.monkey.service.ContentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 审计内容处理程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-11 07:30:45
 */
@Component
public class GetContentByIdHandler implements GatewayHandler<GetContentByIdRequest, GetContentByIdResponse> {

    @Resource
    private ContentService contentService;

    @Override
    public GetContentByIdResponse handle(GetContentByIdRequest request) throws Exception {
        String cid = request.getCid();
        ContentEntity content = contentService.selectById(cid);
        return GetContentByIdResponse.builder().content(content).build();
    }
}
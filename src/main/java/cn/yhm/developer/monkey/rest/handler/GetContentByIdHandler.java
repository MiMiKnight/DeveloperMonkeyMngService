package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.GetContentByIdRequest;
import cn.yhm.developer.monkey.model.response.GetContentByIdResponse;
import cn.yhm.developer.monkey.model.vo.GetContentByIdContentVO;
import cn.yhm.developer.monkey.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 审计内容处理程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-11 07:30:45
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Component
public class GetContentByIdHandler implements GatewayHandler<GetContentByIdRequest, GetContentByIdResponse> {

    @Resource
    private ContentService contentService;

    @Override
    public GetContentByIdResponse handle(GetContentByIdRequest request) throws Exception {
        String cid = request.getCid();
        ContentEntity content = contentService.getById(cid);
        GetContentByIdContentVO contentVO = null;
        // 响应对象
        GetContentByIdResponse response = new GetContentByIdResponse();
        // 查询结果为空
        if (null == content) {
            response.setResult(null);
            return response;
        }
        // 查询结果不为空
        contentVO = GetContentByIdContentVO.builder()
                .id(content.getId())
                .content(content.getContent())
                .deleted(content.getDeleted())
                .version(content.getVersion())
                .createTime(content.getCreateTime())
                .updateTime(content.getUpdateTime())
                .build();
        response.setResult(contentVO);
        return response;

    }
}
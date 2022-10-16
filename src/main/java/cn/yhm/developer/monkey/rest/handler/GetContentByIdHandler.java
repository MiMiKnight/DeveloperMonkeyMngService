package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.exception.EcologyException;
import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.GetContentByIdRequest;
import cn.yhm.developer.monkey.model.response.GetContentByIdResponse;
import cn.yhm.developer.monkey.service.ContentService;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


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
//        String requestURI = servletRequest.getRequestURI();
//        String method = servletRequest.getMethod();
//        String remoteHost = servletRequest.getRemoteHost();
        Long cid = request.getCid();
        int a = 1 / 0;
        ContentEntity content = contentService.getById(cid);
        return GetContentByIdResponse.builder().id(content.getId()).content(content.getContent()).deleted(content.getDeleted()).createTime(content.getCreateTime()).updateTime(content.getUpdateTime()).build();
    }
}
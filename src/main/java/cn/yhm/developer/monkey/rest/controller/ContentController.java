package cn.yhm.developer.monkey.rest.controller;

import cn.yhm.developer.ecology.annotation.ApiLog;
import cn.yhm.developer.ecology.constant.LogApiType;
import cn.yhm.developer.ecology.rest.controller.GatewayController;
import cn.yhm.developer.monkey.model.request.AuditContentRequest;
import cn.yhm.developer.monkey.model.response.AuditContentResponse;
import cn.yhm.developer.monkey.rest.handler.AuditContentHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 22:14:36
 */
@Slf4j
@RestController
@RequestMapping(value = {"/content"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContentController extends GatewayController {

    /**
     * 审核内容接口
     *
     * @param request 请求
     * @return 响应
     */
    @PostMapping(value = {"/audit"})
    @ApiLog(type = LogApiType.Add, anonymous = {""})
    public AuditContentResponse auditContent(@RequestBody @Validated AuditContentRequest request) throws Exception {
        return handle(request, AuditContentHandler.class);
    }
}

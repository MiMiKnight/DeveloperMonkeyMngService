package cn.yhm.developer.monkey.rest.controller;

import cn.yhm.developer.ecology.annotation.ApiLog;
import cn.yhm.developer.ecology.constant.LogApiType;
import cn.yhm.developer.ecology.rest.controller.GatewayController;
import cn.yhm.developer.monkey.model.request.AuditContentRequest;
import cn.yhm.developer.monkey.model.request.GetContentByIdRequest;
import cn.yhm.developer.monkey.model.response.AuditContentResponse;
import cn.yhm.developer.monkey.model.response.GetContentByIdResponse;
import cn.yhm.developer.monkey.rest.handler.AuditContentHandler;
import cn.yhm.developer.monkey.rest.handler.GetContentByIdHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容模块前端控制器
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 22:14:36
 */
@Slf4j
@RestController
@RequestMapping(value = {"/rest/developer/monkey-mng-service/content"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContentController extends GatewayController {

    /**
     * 通过ID查询Content
     */
    @PostMapping(value = {"/get-content-by-id"})
    @ApiLog(type = LogApiType.Query, anonymous = {""})
    public GetContentByIdResponse getContentById(@RequestBody @Validated GetContentByIdRequest request) throws Exception {
        return handle(request, GetContentByIdHandler.class);
    }

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

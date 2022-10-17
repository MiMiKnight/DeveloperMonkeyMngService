package cn.yhm.developer.monkey.rest.handler;

import cn.yhm.developer.ecology.rest.handler.GatewayHandler;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import cn.yhm.developer.monkey.model.request.GetContentsRequest;
import cn.yhm.developer.monkey.model.response.GetContentsResponse;
import cn.yhm.developer.monkey.model.vo.response.GetContentsRespVO;
import cn.yhm.developer.monkey.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 无条件分页查询内容 处理类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 22:31:19
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Component
public class GetContentsHandler implements GatewayHandler<GetContentsRequest, GetContentsResponse> {

    @Resource
    ContentService contentService;

    @Override
    public GetContentsResponse handle(GetContentsRequest request) throws Exception {
        // 总页数
        long total = contentService.count();
        // 每页记录数
        Long pageSize = request.getPageSize();
        // 分页偏移量
        Long offset = request.offset(total);
        // 如果总记录数为0
        if (total < 1L) {
            return request.handleResponse(new GetContentsResponse(), total, null);
        }
        // 分页查询
        List<ContentEntity> results = contentService.getContentByPage(offset, pageSize);
        // 转换
        List<GetContentsRespVO> voResults = results.stream().map(result -> {
            GetContentsRespVO vo = new GetContentsRespVO();
            vo.setId(result.getId());
            vo.setContent(result.getContent());
            vo.setVersion(result.getVersion());
            vo.setDeleted(result.getDeleted());
            vo.setCreateTime(result.getCreateTime());
            vo.setUpdateTime(result.getUpdateTime());
            return vo;
        }).collect(Collectors.toList());
        return request.handleResponse(new GetContentsResponse(), total, voResults);
    }
}

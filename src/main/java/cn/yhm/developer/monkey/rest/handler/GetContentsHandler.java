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
        // 实际页码
        Long actualPageIndex = request.actualPageIndex(total);
        // 总页数
        Long pages = request.pages(total);
        // 分页偏移量
        Long offset = request.offset(total);
        // 响应
        GetContentsResponse response = new GetContentsResponse();
        response.setTotal(total)
                .setPageIndex(actualPageIndex)
                .setPageSize(pageSize);
        // 如果总记录数为0
        if (total < 1L) {
            return response;
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
        // 设置结果集
        response.setResults(voResults);
        return response;
    }
}

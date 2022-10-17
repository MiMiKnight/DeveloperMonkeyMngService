package cn.yhm.developer.monkey.model.request;

import cn.yhm.developer.ecology.model.request.PagingRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 无条件分页查询内容 参数请求类
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 22:26:17
 */
@Accessors(chain = true)
@Setter
@Getter
public class GetContentsRequest extends PagingRequest {
}

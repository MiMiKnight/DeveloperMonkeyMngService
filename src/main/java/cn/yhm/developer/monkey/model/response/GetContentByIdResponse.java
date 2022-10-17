package cn.yhm.developer.monkey.model.response;

import cn.yhm.developer.ecology.model.response.ResultResponse;
import cn.yhm.developer.monkey.model.vo.response.GetContentByIdContentRespVO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 根据ID获取Content响应
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 23:11:20
 */
@Accessors(chain = true)
@Getter
@Setter
public class GetContentByIdResponse extends ResultResponse<GetContentByIdContentRespVO> {

}
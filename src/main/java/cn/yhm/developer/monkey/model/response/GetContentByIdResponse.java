package cn.yhm.developer.monkey.model.response;

import cn.yhm.developer.ecology.model.response.GatewayResponse;
import cn.yhm.developer.ecology.model.response.SuccessResponse;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 根据ID获取Content响应
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 23:11:20
 */
@Builder
@Getter
@Setter
public class GetContentByIdResponse implements GatewayResponse {


    /**
     * 内容对象
     */
    @JsonProperty(value = "content", index = 1)
    private ContentEntity content;

}
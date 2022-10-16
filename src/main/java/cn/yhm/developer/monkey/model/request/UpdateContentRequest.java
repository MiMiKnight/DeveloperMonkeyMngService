package cn.yhm.developer.monkey.model.request;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 更新内容请求
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-15 15:05:02
 */
@Setter
@Getter
public class UpdateContentRequest implements GatewayRequest {

    /**
     * 主键ID
     */
    @NotNull(message = "The parameter can not be null")
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    /**
     * 内容
     */
    @NotBlank(message = "The parameter can not be empty")
    @JsonProperty(value = "content", access = JsonProperty.Access.WRITE_ONLY)
    private String content;
}

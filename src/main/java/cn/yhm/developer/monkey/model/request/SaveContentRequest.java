package cn.yhm.developer.monkey.model.request;

import cn.yhm.developer.ecology.model.request.GatewayRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 保存内容请求
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-15 11:26:31
 */
@Getter
@Setter
public class SaveContentRequest implements GatewayRequest {

    /**
     * 内容
     */
    @NotBlank(message = "The parameter can not be empty")
    @Length(min = 1, max = 2048, message = "The length of parameter between 1 and 2048")
    @JsonProperty(value = "content", access = JsonProperty.Access.WRITE_ONLY)
    private String content;
}

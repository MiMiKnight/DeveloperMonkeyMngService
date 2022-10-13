package cn.yhm.developer.monkey.model.request;

import cn.yhm.developer.ecology.annotation.validate.DateTimeFormatValidate;
import cn.yhm.developer.ecology.annotation.validate.EnumerateIntegerValidate;
import cn.yhm.developer.ecology.model.request.GatewayRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 根据ID获取Content请求
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-13 23:10:40
 */
@Getter
@Setter
public class GetContentByIdRequest implements GatewayRequest {

    /**
     * 主键ID
     */
    @NotBlank(message = "The parameter can not be empty")
    @JsonProperty(value = "cid", index = 1, access = JsonProperty.Access.WRITE_ONLY)
    private String cid;

}

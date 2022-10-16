package cn.yhm.developer.monkey.model.request;

import cn.yhm.developer.ecology.annotation.validate.DateTimeFormatValidate;
import cn.yhm.developer.ecology.annotation.validate.EnumerateIntegerValidate;
import cn.yhm.developer.ecology.model.request.GatewayRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 审核内容请求
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-04 22:30:19
 */
@Getter
@Setter
public class AuditContentRequest implements GatewayRequest {

    /**
     * 审核时间
     */
    @NotNull(message = "The parameter can not be null or empty")
    @DateTimeFormatValidate(message = "日期参数非法")
    @JsonProperty(value = "audit_time", access = JsonProperty.Access.WRITE_ONLY)
    private String auditTime;

    /**
     * 审核结果
     * 1：审核通过
     * 2：审核不通过
     * 3：转他人审核
     */
    @NotNull(message = "The parameter can not be null")
    @EnumerateIntegerValidate(value = {1, 2, 3}, message = "The parameter of value is out of range")
    @JsonProperty(value = "audit_result", access = JsonProperty.Access.WRITE_ONLY)
    private Integer auditResult;
}

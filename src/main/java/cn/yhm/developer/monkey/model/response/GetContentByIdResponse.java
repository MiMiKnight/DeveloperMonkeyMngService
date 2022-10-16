package cn.yhm.developer.monkey.model.response;

import cn.yhm.developer.ecology.constant.DateTimeFormatPattern;
import cn.yhm.developer.ecology.constant.TimeZoneGMT;
import cn.yhm.developer.ecology.model.response.GatewayResponse;
import cn.yhm.developer.ecology.model.response.SuccessResponse;
import cn.yhm.developer.monkey.model.entity.ContentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
     * 内容ID
     */
    @JsonProperty(value = "id", index = 1, access = JsonProperty.Access.READ_ONLY)
    private Long id;

    /**
     * 内容
     */
    @JsonProperty(value = "content", index = 2, access = JsonProperty.Access.READ_ONLY)
    private String content;

    /**
     * 逻辑删除
     */
    @JsonProperty(value = "deleted", index = 3, access = JsonProperty.Access.READ_ONLY)
    private Integer deleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DateTimeFormatPattern.STANDARD_4, timezone = TimeZoneGMT.UK.GREENWICH)
    @JsonProperty(value = "create_time", index = 4, access = JsonProperty.Access.READ_ONLY)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = DateTimeFormatPattern.STANDARD_4, timezone = TimeZoneGMT.UK.GREENWICH)
    @JsonProperty(value = "update_time", index = 5, access = JsonProperty.Access.READ_ONLY)
    private Date updateTime;

}
package cn.yhm.developer.monkey.model.vo;

import cn.yhm.developer.ecology.common.constant.DateTimeFormatPattern;
import cn.yhm.developer.ecology.common.constant.TimeZoneGMT;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ContentVO
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-17 07:11:54
 */
@Builder
@Setter
@Getter
public class GetContentByIdContentVO {

    /**
     * 主键ID
     */
    @JsonProperty(value = "id", index = 1, access = JsonProperty.Access.READ_ONLY)
    private String id;

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
     * 乐观锁
     */
    @JsonProperty(value = "version", index = 4, access = JsonProperty.Access.READ_ONLY)
    private Integer version;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DateTimeFormatPattern.STANDARD_4, timezone = TimeZoneGMT.UK.GREENWICH)
    @JsonProperty(value = "create_time", index = 5, access = JsonProperty.Access.READ_ONLY)
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = DateTimeFormatPattern.STANDARD_4, timezone = TimeZoneGMT.UK.GREENWICH)
    @JsonProperty(value = "update_time", index = 6, access = JsonProperty.Access.READ_ONLY)
    private Date updateTime;
}

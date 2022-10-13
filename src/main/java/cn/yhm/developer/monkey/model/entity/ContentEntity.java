package cn.yhm.developer.monkey.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 内容实体
 * 内容持久化对象
 * <p>
 * 数据库：db_monkey
 * 表：t_monkey_content
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-06 00:11:24
 */
@Getter
@Setter
//@TableName(value = "t_monkey_content", schema = "db_monkey")
public class ContentEntity {

    /**
     * 内容ID
     */
//    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 内容
     */
//    @TableField(value = "content")
    private String content;

    /**
     * 逻辑删除
     */
//    @TableField(value = "deleted")
//    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    /**
     * 创建时间
     */
//    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
//    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

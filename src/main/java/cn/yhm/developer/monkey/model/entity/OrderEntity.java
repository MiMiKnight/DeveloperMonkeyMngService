package cn.yhm.developer.monkey.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表实体类
 * <p>
 * 数据库：db_monkey
 * <p>
 * 表：t_monkey_order
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-09-06 00:11:24
 */
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@TableName(value = "t_monkey_order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 5138268735377856424L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 订单序列号
     */
    @TableField(value = "serial_number")
    private String serialNumber;

    /**
     * 订单名称
     */
    @TableField(value = "order_name")
    private String orderName;

    /**
     * 订单类型
     * 一般订单：1
     * 拍卖订单：2
     * 代购订单：3
     * 分期订单：4
     * 积分订单：5
     */
    @TableField(value = "order_type")
    private String orderType;

    /**
     * 卖家用户ID
     */
    @TableField(value = "buyer")
    private String buyer;

    /**
     * 卖家用户ID
     */
    @TableField(value = "seller")
    private String seller;

    /**
     * 支付时间
     */
    @TableField(value = "payment_time")
    private Date paymentTime;

    /**
     * 支付方式
     * <p>
     * 支付宝：1
     * 微信：2
     * 信用卡：3
     * 储蓄卡：4
     */
    @TableField(value = "payment_method")
    private String paymentMethod;

    /**
     * 订单总金额
     */
    @TableField(value = "amount")
    private Long amount;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

package com.example.smsless.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("location")
public class WarehouseVO {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String type;

    private String name;

    private String address;

    private BigDecimal totalCapacity;

    // 非数据库字段（用于存储已用容量）
    @TableField(exist = false)
    private BigDecimal usedCapacity;

    // 非数据库字段（用于存储员工列表）
    @TableField(exist = false)
    private List<Employee> employees;


}

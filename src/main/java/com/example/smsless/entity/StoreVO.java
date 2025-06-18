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
public class StoreVO {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String type;
    private String name;
    private String address;

    private BigDecimal totalCapacity;
    @TableField(exist = false)
    private BigDecimal usedCapacity;

    @TableField(exist = false)
    private List<Employee> employees;

    //总成本
    @TableField(exist = false)//数据库表中不存在的字段
    private BigDecimal totalCost;
    //总利润
    @TableField(exist = false)
    private BigDecimal totalProfit;
    //总营业额
    @TableField(exist = false)
    private BigDecimal totalRevenue;

}

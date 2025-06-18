package com.example.smsless.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok的注解，自动生成getter，setter，toString等方法
@Data
//无参&有参构造函数
@NoArgsConstructor
@AllArgsConstructor
//表示该类有构建者模式
@Builder
//表示该类对应数据库中的表
@TableName("employee")
public class Employee {
    //@TableField(value="字段名")一样可以省略
    //表示该字段对应数据库中的主键,IdType表示主键生成策略，AUTO表示自增,默认是none
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    //职务
    private String position;
    //联系方式
    private String contact;
    //部门id
    private int locationId;
}

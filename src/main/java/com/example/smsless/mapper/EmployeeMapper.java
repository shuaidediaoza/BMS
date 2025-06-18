package com.example.smsless.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smsless.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//继承BaseMapper，泛型为实体类
public interface EmployeeMapper extends BaseMapper<Employee> {
//    int insert(@Param("employee") Employee employee);
//    int deleteById(@Param("id") Integer id);
//    int update(@Param("employee") Employee employee);
//    Employee selectById(@Param("id") Integer id);
//    List<Employee> selectAll();
}

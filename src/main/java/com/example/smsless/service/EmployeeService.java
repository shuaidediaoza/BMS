package com.example.smsless.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.smsless.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    void updateEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByPosition(String  position);

    //分页查询员工信息
    IPage<Employee> getEmployeesByPage(int pageNum, int pageSize);
}

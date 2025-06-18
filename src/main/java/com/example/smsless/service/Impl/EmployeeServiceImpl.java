package com.example.smsless.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.smsless.entity.Employee;
import com.example.smsless.mapper.EmployeeMapper;
import com.example.smsless.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private  EmployeeMapper employeeMapper;
    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateById(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        employeeMapper.selectById(id);
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectList(null);
    }

    @Override
    public List<Employee> getEmployeesByPosition(String  position) {
        return employeeMapper.selectList(new QueryWrapper<Employee>().eq("position", position));
    }

    @Override
    public IPage<Employee> getEmployeesByPage(int pageNum, int pageSize) {
        //创建page对象，指定当前页码和每页大小
        IPage<Employee> page = new Page<>(pageNum, pageSize);
        //查询所有员工并分页
        return employeeMapper.selectPage(page, null);
    }
}

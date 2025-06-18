package com.example.smsless.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.smsless.entity.Employee;
import com.example.smsless.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService  employeeService;
    @PostMapping
    public void addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping  ("/{id}")
    public void deleteEmployee(@PathVariable Integer id)
    {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/position/{position}")
    public List<Employee> getEmployeesByPosition(@PathVariable String position) {
        return employeeService.getEmployeesByPosition(position);
    }

    // 分页接口
    @GetMapping("/page")
    public IPage<Employee> getEmployeesByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "8") int pageSize) {
        return employeeService.getEmployeesByPage(pageNum, pageSize);
    }
}

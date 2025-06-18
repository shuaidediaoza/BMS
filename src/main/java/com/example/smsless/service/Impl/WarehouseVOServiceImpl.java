package com.example.smsless.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smsless.entity.Employee;
import com.example.smsless.entity.WarehouseVO;
import com.example.smsless.mapper.EmployeeMapper;
import com.example.smsless.mapper.WarehouseVOMapper;
import com.example.smsless.service.WarehouseVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WarehouseVOServiceImpl implements WarehouseVOService {

    @Autowired
    private WarehouseVOMapper  warehouseVOMapper;

    @Autowired
    private EmployeeMapper  employeeMapper;

    @Override
    public List<WarehouseVO> getAllWarehouse() {
        //查询仓库基本信息及容量
        List<WarehouseVO> warehouseVOList = warehouseVOMapper.selectAllWarehouseWithCapacity();

        // 2. 批量查询所有仓库的员工
        Map<Integer, List<Employee>> employeeMap = employeeMapper.selectList(
                new QueryWrapper<Employee>().in("location_id",
                        warehouseVOList.stream().map(WarehouseVO::getId).collect(Collectors.toList()))
        ).stream().collect(Collectors.groupingBy(Employee::getLocationId));

        // 3. 关联员工数据到仓库
        warehouseVOList.forEach(warehouse ->
                warehouse.setEmployees(employeeMap.getOrDefault(warehouse.getId(), Collections.emptyList()))
        );

        return warehouseVOList;
    }

    @Override
    public WarehouseVO getWarehouseById(Integer id) {
        WarehouseVO warehouseVO = warehouseVOMapper.selectWarehouseById(id);
        //查询仓库员工
        List<Employee> employeeList = employeeMapper.selectList(
                new QueryWrapper<Employee>().eq("location_id", id)
        );
        //关联员工数据到仓库
        warehouseVO.setEmployees(employeeList);

        return warehouseVO;
    }


}

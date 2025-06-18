package com.example.smsless.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.smsless.entity.Employee;
import com.example.smsless.entity.StoreVO;
import com.example.smsless.entity.WarehouseVO;
import com.example.smsless.mapper.EmployeeMapper;
import com.example.smsless.mapper.StoreVOMapper;
import com.example.smsless.service.StoreVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreVOServiceImpl implements StoreVOService {

    @Autowired
    private StoreVOMapper storeVOMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<StoreVO> getStore(){
        List<StoreVO> storeVOList = storeVOMapper.selectStoreVo();

        // 2. 批量查询所有仓库的员工
        Map<Integer, List<Employee>> employeeMap = employeeMapper.selectList(
                new QueryWrapper<Employee>().in("location_id",
                        storeVOList.stream().map(StoreVO::getId).collect(Collectors.toList()))
        ).stream().collect(Collectors.groupingBy(Employee::getLocationId));

        // 3. 关联员工数据到仓库
        storeVOList.forEach(warehouse ->
                warehouse.setEmployees(employeeMap.getOrDefault(warehouse.getId(), Collections.emptyList()))
        );



        return storeVOList;
    }

    @Override
    public StoreVO getStoreById(Integer id){
        StoreVO storeVO = storeVOMapper.selectStoreVoById(id);

        // 2. 查询仓库的员工
        List<Employee> employees = employeeMapper.selectList(
                new QueryWrapper<Employee>().eq("location_id", id)
        );

        // 3. 关联员工数据到仓库
        storeVO.setEmployees(employees);

        return storeVO;
    }

}

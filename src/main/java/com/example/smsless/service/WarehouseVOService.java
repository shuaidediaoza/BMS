package com.example.smsless.service;

import com.example.smsless.entity.WarehouseVO;

import java.util.List;

public interface WarehouseVOService {
    List<WarehouseVO> getAllWarehouse();

    WarehouseVO getWarehouseById(Integer id);
}

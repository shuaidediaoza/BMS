package com.example.smsless.controller;

import com.example.smsless.entity.WarehouseVO;
import com.example.smsless.service.WarehouseVOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseVOController {
    private final WarehouseVOService warehouseVOService;

    public WarehouseVOController(WarehouseVOService warehouseVOService) {
        this.warehouseVOService = warehouseVOService;
    }

    @GetMapping()
    public List<WarehouseVO> getAllWarehouse() {
        return warehouseVOService.getAllWarehouse();
    }

    @RequestMapping("/{id}")
    public WarehouseVO getWarehouseById(@PathVariable  Integer id) {
        return warehouseVOService.getWarehouseById(id);
    }
}

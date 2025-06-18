package com.example.smsless.controller;


import com.example.smsless.entity.StoreVO;
import com.example.smsless.mapper.StoreVOMapper;
import com.example.smsless.service.Impl.StoreVOServiceImpl;
import com.example.smsless.service.StoreVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storeVO")
public class StoreVOController {

    @Autowired
    private StoreVOService  storeVOService;
    @GetMapping("/getAllStore")
    public List<StoreVO> getStore()
    {
        return storeVOService.getStore();
    }
    @GetMapping("/{id}")
    public StoreVO getStoreById(@PathVariable Integer id)
    {
        return storeVOService.getStoreById(id);
    }

}

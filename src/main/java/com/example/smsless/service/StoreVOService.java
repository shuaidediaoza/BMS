package com.example.smsless.service;

import com.example.smsless.entity.StoreVO;

import java.util.List;

public interface StoreVOService {
    List<StoreVO> getStore();
    StoreVO getStoreById(Integer id);
}

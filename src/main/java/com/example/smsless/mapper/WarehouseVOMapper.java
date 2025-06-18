package com.example.smsless.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smsless.entity.WarehouseVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WarehouseVOMapper extends BaseMapper<WarehouseVO> {

    //查询所有仓库
    List<WarehouseVO> selectAllWarehouseWithCapacity();

    //根据id查询仓库
    WarehouseVO  selectWarehouseById(Integer id);
}

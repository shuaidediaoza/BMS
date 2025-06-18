package com.example.smsless.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smsless.entity.StoreVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoreVOMapper extends BaseMapper<StoreVOMapper> {

    List<StoreVO> selectStoreVo();

    StoreVO selectStoreVoById(Integer id);
}

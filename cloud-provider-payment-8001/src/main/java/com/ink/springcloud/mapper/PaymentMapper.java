package com.ink.springcloud.mapper;

import com.ink.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);
}
package com.ink.springcloud.service.impl;

import com.ink.springcloud.domain.Payment;
import com.ink.springcloud.mapper.PaymentMapper;
import com.ink.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

}

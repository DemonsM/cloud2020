package com.ink.springcloud.service;

import com.ink.springcloud.domain.Payment;

public interface PaymentService {


    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

}

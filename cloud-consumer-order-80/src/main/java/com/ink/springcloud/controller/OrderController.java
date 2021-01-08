package com.ink.springcloud.controller;

import com.ink.springcloud.common.CommonResult;
import com.ink.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author MT
 * @date 2021/1/8 10:56
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String PAYMENT_URL = "http://127.0.0.1:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/create/payment")
    public CommonResult<Payment> createPayment(Payment payment) {
        log.info("123123");
        return restTemplate.postForObject(PAYMENT_URL + "/pay/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, CommonResult.class);
    }
}

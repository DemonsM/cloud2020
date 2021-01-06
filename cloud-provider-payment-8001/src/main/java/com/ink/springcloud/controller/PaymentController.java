package com.ink.springcloud.controller;

import com.ink.springcloud.common.CommonResult;
import com.ink.springcloud.domain.Payment;
import com.ink.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author MT
 * @date 2021/1/6 13:18
 */
@Slf4j
@RestController
@RequestMapping("/pay")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        log.info("查询结果是：{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(404, "查询失败,id: " + id);
        }
    }

    @PostMapping("/create")
    public CommonResult<Integer> createPayment(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        log.info("插入结果：{}", insert);
        if (insert > 0) {
            return new CommonResult<>(200, "插入成功", insert);
        } else {
            return new CommonResult<>(404, "插入失败");
        }
    }
}

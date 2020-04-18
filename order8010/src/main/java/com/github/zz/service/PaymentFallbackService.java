package com.github.zz.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public String paymentHystrixOk(Integer id) {
        return "paymentHystrixOk___Fallback";
    }

    @Override
    public String paymentHystrixTimeout(Integer id) {
        return "paymentHystrixTimeout____Fallback";
    }
}

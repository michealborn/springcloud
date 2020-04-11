package com.github.zz.service;

import com.github.zz.dao.PaymentDao;
import com.github.zz.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class PaymentService {
    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getById(@Param("id") Long id){
        return paymentDao.getById(id);
    }
}

package com.invillia.acme.controller;

import com.invillia.acme.common.PaymentDTO;
import com.invillia.acme.common.PaymentStatusType;
import com.invillia.acme.common.PurchaseOrderStatusType;
import com.invillia.acme.model.Payment;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.repository.PurchaseOrderRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
@Api(value = "Payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @PostMapping
    Payment save(@RequestBody PaymentDTO payment) {
        purchaseOrderRepository.findById(payment.getPurchaseOrder().getId())
                .ifPresent(purchaseOrder -> {
                    purchaseOrder.setStatus(PurchaseOrderStatusType.PAID_OUT);
                    purchaseOrderRepository.save(purchaseOrder);
                });

        payment.setStatus(PaymentStatusType.PAID_OUT);

        return paymentRepository.save(PaymentDTO.toEntity(payment));
    }

    @GetMapping
    Page<Payment> list() {
        return paymentRepository.findAll(PageRequest.of(0, 100));
    }
}

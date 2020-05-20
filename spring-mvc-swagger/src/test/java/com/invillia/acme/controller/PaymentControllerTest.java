package com.invillia.acme.controller;

import com.invillia.acme.common.PaymentDTO;
import com.invillia.acme.common.PaymentStatusType;
import com.invillia.acme.common.PurchaseOrderStatusType;
import com.invillia.acme.common.UnitBaseTest;
import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PurchaseOrder;
import com.invillia.acme.repository.PaymentRepository;
import com.invillia.acme.repository.PurchaseOrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

public class PaymentControllerTest extends UnitBaseTest {

    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private PurchaseOrderRepository purchaseOrderRepository;
    @InjectMocks
    private PaymentController paymentController;

    @Override
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save_withAllParameters_success() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setId(UUID.randomUUID());
        purchaseOrder.setStatus(PurchaseOrderStatusType.PAID_OUT);

        Payment payment = new Payment();
        payment.setId(UUID.randomUUID());
        payment.setPurchaseOrder(purchaseOrder);
        payment.setStatus(PaymentStatusType.PAID_OUT);

        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setPurchaseOrder(purchaseOrder);

        Mockito.when(purchaseOrderRepository.findById(purchaseOrder.getId()))
                .thenReturn(Optional.of(purchaseOrder));

        Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class)))
                .thenReturn(purchaseOrder);

        Mockito.when(paymentRepository.save(Mockito.any(Payment.class)))
                .thenReturn(payment);

        Payment output = paymentController.save(dto);

        Assert.assertEquals(PurchaseOrderStatusType.PAID_OUT, output.getPurchaseOrder().getStatus());
        Assert.assertEquals(PaymentStatusType.PAID_OUT, output.getStatus());
    }
}
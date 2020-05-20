package com.invillia.acme.common;

import com.invillia.acme.model.Payment;
import com.invillia.acme.model.PurchaseOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private UUID id;
    private PurchaseOrder purchaseOrder;
    private PaymentStatusType status;
    private String creditCardNumber;
    private LocalDate paymentDate;
    private Double refundValue;

    public static Payment toEntity(PaymentDTO dto) {
        if (dto == null) return new Payment();
        return new Payment(dto.id, dto.purchaseOrder, dto.status, dto.creditCardNumber, dto.paymentDate, dto.refundValue);
    }
}

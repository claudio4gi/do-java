package com.invillia.acme.model;

import com.invillia.acme.common.PaymentStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Payment extends CommonEntity {

    @Id
    private UUID id;
    @OneToOne
    private PurchaseOrder purchaseOrder;

    private PaymentStatusType status;
    private String creditCardNumber;
    private LocalDate paymentDate;
    private Double refundValue;

}

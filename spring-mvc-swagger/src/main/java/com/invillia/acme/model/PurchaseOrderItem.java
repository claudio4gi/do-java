package com.invillia.acme.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PurchaseOrderItem extends CommonEntity {

    @Id
    private UUID id;
    @ManyToOne
    private PurchaseOrder purchaseOrder;

    private String description;
    private Double unitPrice;
    private Integer quantity;

}

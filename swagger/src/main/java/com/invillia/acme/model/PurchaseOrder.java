package com.invillia.acme.model;

import com.invillia.acme.common.PurchaseOrderStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PurchaseOrder extends CommonEntity {

    @Id
    private UUID id;
    @OneToOne
    private Store store;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> purchaseOrderItem;

    private String customer;
    private String address;
    private LocalDate confirmationDate;
    private PurchaseOrderStatusType status;

}

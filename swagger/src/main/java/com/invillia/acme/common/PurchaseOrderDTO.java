package com.invillia.acme.common;

import com.invillia.acme.model.PurchaseOrder;
import com.invillia.acme.model.PurchaseOrderItem;
import com.invillia.acme.model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDTO {

    private UUID id;
    private Store store;
    private List<PurchaseOrderItem> purchaseOrderItem;
    private String customer;
    private String address;
    private LocalDate confirmationDate;
    private PurchaseOrderStatusType status;

    public static PurchaseOrder toEntity(PurchaseOrderDTO dto) {
        if (dto == null) return new PurchaseOrder();
        return new PurchaseOrder(dto.id, dto.store, dto.purchaseOrderItem, dto.customer, dto.address, dto.confirmationDate, dto.status);
    }

    public static Example<PurchaseOrder> ofFilter(PurchaseOrderDTO dto) {
        return Example.of(toEntity(dto));
    }
}

package com.invillia.acme.controller;

import com.invillia.acme.common.PurchaseOrderDTO;
import com.invillia.acme.common.PurchaseOrderStatusType;
import com.invillia.acme.model.PurchaseOrder;
import com.invillia.acme.repository.PurchaseOrderRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping(value = "/purchaseOrder")
@Api(value = "PurchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRepository repository;

    @PostMapping
    private PurchaseOrder save(@RequestBody PurchaseOrderDTO purchaseOrder) {
        purchaseOrder.setStatus(PurchaseOrderStatusType.PENDING);
        return repository.save(PurchaseOrderDTO.toEntity(purchaseOrder));
    }

    @GetMapping("/{id}")
    private PurchaseOrder retrieve(@PathVariable("id") UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    private Page<PurchaseOrder> list(@RequestBody(required = false) PurchaseOrderDTO purchaseOrder) {
        return repository.findAll(PurchaseOrderDTO.ofFilter(purchaseOrder), PageRequest.of(0, 100));
    }
}

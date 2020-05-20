package com.invillia.acme.controller;

import com.invillia.acme.common.StoreDTO;
import com.invillia.acme.model.Store;
import com.invillia.acme.repository.StoreRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping(value = "/store")
@Api(value = "Store")
public class StoreController {

    @Autowired
    private StoreRepository repository;

    @PostMapping
    private Store save(@RequestBody StoreDTO store) {
        return repository.save(StoreDTO.toEntity(store));
    }

    @PutMapping
    private Store update(@RequestBody StoreDTO store) {
        if (!repository.existsById(store.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return repository.save(StoreDTO.toEntity(store));
    }

    @GetMapping("/{id}")
    private Store retrieve(@PathVariable("id") UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    private Page<Store> list(@RequestBody(required = false) StoreDTO storeDTO) {
        return repository.findSpecial(storeDTO, PageRequest.of(0, 100));
    }
}

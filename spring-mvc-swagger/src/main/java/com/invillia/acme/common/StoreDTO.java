package com.invillia.acme.common;

import com.invillia.acme.model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {

    private UUID id;
    private String name;
    private String address;

    public static Store toEntity(StoreDTO dto) {
        if (dto == null) return new Store();
        return new Store(dto.id, dto.name, dto.address);
    }
}

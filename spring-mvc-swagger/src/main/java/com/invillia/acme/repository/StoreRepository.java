package com.invillia.acme.repository;

import com.invillia.acme.common.StoreDTO;
import com.invillia.acme.model.Store;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {

    Page<Store> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Store> findByAddressContainingIgnoreCase(String name, Pageable pageable);

    Page<Store> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address, Pageable pageable);

    /**
     * Aqui também podemos usar o Criterial para montar o comando e retornar os dados.
     *
     * @param storeDTO DTO de entrada.
     * @param pageable Dado da paginação.
     * @return Dados de retorno.
     */
    default Page<Store> findSpecial(StoreDTO storeDTO, Pageable pageable) {
        if (storeDTO != null && StringUtils.isNotBlank(storeDTO.getName()) && StringUtils.isNotBlank(storeDTO.getAddress()))
            return findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(storeDTO.getName(), storeDTO.getAddress(), pageable);
        else if (storeDTO != null && StringUtils.isNotBlank(storeDTO.getName()))
            return findByNameContainingIgnoreCase(storeDTO.getName(), pageable);
        else if (storeDTO != null && StringUtils.isNotBlank(storeDTO.getAddress()))
            return findByAddressContainingIgnoreCase(storeDTO.getAddress(), pageable);
        else
            return findAll(pageable);
    }
}

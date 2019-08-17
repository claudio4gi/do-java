package com.invillia.acme.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
public abstract class CommonEntity {

    abstract UUID getId();

    abstract void setId(UUID id);

    @PrePersist
    private void persist() {
        if (getId() == null) {
            setId(UUID.randomUUID());
        }
    }
}

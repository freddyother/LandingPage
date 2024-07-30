package com.realestate.rentalandsales.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class JpaEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false)
    protected String id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    protected Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modifiedAt;
}

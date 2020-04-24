package com.svidal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "change")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Change {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destiny;

    @Column(nullable = false)
    private Double change;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date updated;

    @PrePersist
    private void prePersist() {
        this.created = this.updated = new Date();
    }

    @PreUpdate
    private void preUpdated() {
        this.updated = new Date();
    }
}

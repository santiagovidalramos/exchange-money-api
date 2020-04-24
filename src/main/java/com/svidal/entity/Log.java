package com.svidal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Change.class)
    @JoinColumn(name = "money_exchange")
    private Change change;

    @Column
    private Double amount;

    @Column
    private Double amountConverted;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;

    @PrePersist
    private void prePersist() {
        this.created = new Date();
    }
}

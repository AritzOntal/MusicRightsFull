package com.svalero.music.rights.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "claims")

public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La referencia no puede ser nula")
    @Column
    private String reference;

    @Column
    private String status;

    @Column
    private String type;

    @Column
    private String description;

    @Column
    private boolean pending;

    //TODO INTEGRAR FLOAT
    @JsonIgnoreProperties("works")
    @ManyToOne
    @JoinColumn(name = "musician_id")
    private Musician musician;

}

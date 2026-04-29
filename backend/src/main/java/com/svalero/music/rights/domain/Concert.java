package com.svalero.music.rights.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "concerts")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String showTitle;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String province;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String status;

    @NotNull(message = "El estado del concierto no puede ser nulo")
    @Column
    private boolean performed;

    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    @Column
    private float ticketPrice;

    @Column
    private Double longitude;

    @Column
    private Double latitude;

    @JsonIgnoreProperties("works")
    @ManyToOne
    @JoinColumn(name = "musician_id")

    private Musician musician;
}
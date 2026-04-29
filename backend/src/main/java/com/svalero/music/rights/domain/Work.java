package com.svalero.music.rights.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "works")


public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Pattern(
            regexp = "^[A-Z]{2}[A-Z0-9]{3}\\d{2}\\d{5}$",
            message = "ISRC inválido (ej: ESABC2300123)"
    )
    @Column(nullable = false, unique = true)
    private String isrc;

    @NotBlank
    @Column(nullable = false)
    private String genre;

    @Positive
    @Column
    private Float duration;

    @PastOrPresent
    @Column
    private LocalDate composedAt;

    @Column(nullable = false)
    private boolean registred;

    @JsonIgnoreProperties("works")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "musician_work",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    //SE CREA LA TABLA JOIN ENTRE MUCHOS A MUCHOS

    private List<Musician> musicians; //LISTA DE MUSICOS
}

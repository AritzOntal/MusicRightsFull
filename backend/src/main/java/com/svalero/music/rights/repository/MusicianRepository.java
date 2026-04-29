package com.svalero.music.rights.repository;

import com.svalero.music.rights.domain.Musician;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

    @Query("SELECT m FROM Musician m WHERE " +
            "(:performanceFee IS NULL OR m.performanceFee = :performanceFee) AND " +
            "(:affiliated IS NULL OR m.affiliated = :affiliated) AND " +
            "(:birthDate IS NULL OR m.birthDate = :birthDate)")
    List<Musician> findByFilters(Float performanceFee, Boolean affiliated, LocalDate birthDate);
}

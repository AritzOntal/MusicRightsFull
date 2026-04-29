package com.svalero.music.rights.repository;

import com.svalero.music.rights.domain.Concert;
import com.svalero.music.rights.domain.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO HACER LA CONSULTA RELACION JOIN

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query("SELECT c FROM Concert c JOIN c.musician m WHERE m.id = :id")
    List<Concert> findByMusicianId(@Param("id") Long id);

    @Query("SELECT c FROM Concert c WHERE " +
            "(:city IS NULL OR c.city = :city) AND " +
            "(:status IS NULL OR c.status = :status) AND " +
            "(:performed IS NULL OR c.performed = :performed)")
    List<Concert> findByFilters(String city, String status, Boolean performed);

}


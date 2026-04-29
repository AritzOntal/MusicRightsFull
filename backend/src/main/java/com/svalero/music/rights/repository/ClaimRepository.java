package com.svalero.music.rights.repository;

import com.svalero.music.rights.domain.Claim;
import com.svalero.music.rights.exception.ClaimNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

    @Query ("SELECT c FROM Claim c JOIN c.musician m WHERE m.id = :id")

    List <Claim> findByMusicianId(@Param("id") long id);

    @Query("SELECT c FROM Claim c WHERE " +
            "(:status IS NULL OR c.status = :status) AND " +
            "(:type IS NULL OR c.type = :type) AND " +
            "(:pending IS NULL OR c.pending = :pending)")
    List <Claim> findByFilters(String status, String type, Boolean pending);
}

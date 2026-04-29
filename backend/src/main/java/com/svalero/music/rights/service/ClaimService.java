package com.svalero.music.rights.service;


import com.svalero.music.rights.domain.Claim;
import com.svalero.music.rights.domain.Musician;
import com.svalero.music.rights.exception.ClaimNotFoundException;
import com.svalero.music.rights.exception.MusicianNotFoundException;
import com.svalero.music.rights.repository.ClaimRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.svalero.music.rights.repository.MusicianRepository;

import java.util.List;

@Service
public class ClaimService {

    private final MusicianRepository musicianRepository;
    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository, MusicianRepository musicianRepository) {
        this.claimRepository = claimRepository;
        this.musicianRepository = musicianRepository;
    }

    public Claim add(Claim claim) {
        Long idMusician = claim.getMusician().getId();

        if (idMusician != null) {
            Musician musicianDb = musicianRepository.findById(idMusician)
                    .orElseThrow(MusicianNotFoundException::new);
            claim.setMusician(musicianDb);
        }

        return claimRepository.save(claim);
    }

    public ResponseEntity<List<Claim>> findAll(String status, String type, Boolean pending) {

        List<Claim> claims;
        claims = claimRepository.findByFilters(status, type, pending);
        return new ResponseEntity<>(claims, HttpStatus.OK);

    }

    public Claim findById(Long id) throws ClaimNotFoundException {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(ClaimNotFoundException::new);
        return claim;
    }

    public Claim modify(long id, Claim updatedClaim) throws ClaimNotFoundException {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(ClaimNotFoundException::new);

        claim.setType(updatedClaim.getType());
        claim.setDescription(updatedClaim.getDescription());
        claim.setStatus(updatedClaim.getStatus());
        claim.setReference(updatedClaim.getReference());

        claimRepository.save(claim);
        return claim;
    }

    public void delete(long id) throws ClaimNotFoundException {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(ClaimNotFoundException::new);

        claimRepository.delete(claim);
    }

    //FILTRADOS
    public List<Claim> findByMusicianId(long id) throws MusicianNotFoundException {
        musicianRepository.findById(id)
                .orElseThrow(MusicianNotFoundException::new);

        return claimRepository.findByMusicianId(id);
    }
}

package com.svalero.music.rights.service;

import com.svalero.music.rights.domain.Concert;
import com.svalero.music.rights.domain.Musician;
import com.svalero.music.rights.exception.ConcertNotFoundException;
import com.svalero.music.rights.exception.MusicianNotFoundException;
import com.svalero.music.rights.repository.ConcertRepository;
import com.svalero.music.rights.repository.MusicianRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {

    private ConcertRepository concertRepository;
    private MusicianRepository musicianRepository;

    public ConcertService(ConcertRepository concertRepository, MusicianRepository musicianRepository) {
        this.concertRepository = concertRepository;
        this.musicianRepository = musicianRepository;
    }

    public Concert add(Concert concert) {
        Long idMusician = concert.getMusician().getId();

        if (idMusician != null) {
            Musician musicianDb = musicianRepository.findById(idMusician)
                    .orElseThrow(MusicianNotFoundException::new);
            concert.setMusician(musicianDb);
        }
        return concertRepository.save(concert);
    }

    public ResponseEntity<List<Concert>> findAll(String city, String status, Boolean performed) {
        List<Concert> concerts;
        concerts = concertRepository.findByFilters(city, status, performed);
        return new ResponseEntity<>(concerts, HttpStatus.OK);
    }

    public Concert findById(long id) {
        concertRepository.findById(id)
                .orElseThrow(ConcertNotFoundException::new);
        return concertRepository.findById(id).get();
    }

    public List<Concert> findAllbyMusicianId(Long id) {
        List<Concert> allConcerts = concertRepository.findByMusicianId(id);
        return allConcerts;
    }
    //LLAMADA PARA RETORNAR TODOS LOS CONCIERTOS DE UN MUSICO

    public Concert edit(long id, Concert updateConcert) {
        Concert concert = concertRepository.findById(id)
                .orElseThrow(ConcertNotFoundException::new);

        concert.setShowTitle(updateConcert.getShowTitle());
        concert.setCity(updateConcert.getCity());
        concert.setProvince(updateConcert.getProvince());
        concert.setTicketPrice(updateConcert.getTicketPrice());
        concert.setLongitude(updateConcert.getLongitude());
        concert.setPerformed(updateConcert.isPerformed());
        concert.setLatitude(updateConcert.getLatitude());
        concert.setStatus(updateConcert.getStatus());
        concert.setMusician(updateConcert.getMusician());
        concert.setDate(updateConcert.getDate());

        concertRepository.save(concert);
        return concert;
    }

    public void delete(long id) {
        concertRepository.findById(id)
                .orElseThrow(ConcertNotFoundException::new);
        concertRepository.deleteById(id);
    }
}

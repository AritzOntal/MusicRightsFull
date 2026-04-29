package com.svalero.music.rights.util;

import com.svalero.music.rights.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class EntityTest {

    public static Concert testConcert(Boolean correctRequest) {

        if (!correctRequest) {

            Musician musician = new Musician();
            musician.setId(1L);

            Concert concert = new Concert();
            concert.setId(1L);
            concert.setStatus("open");
            concert.setCity("portu");
            concert.setDate(LocalDate.now());
            concert.setLatitude(23124D);
            concert.setShowTitle(null);
            concert.setLongitude(1232D);
            concert.setProvince("Madrid");

            return concert;
        }
        Concert concert = new Concert();
        concert.setId(1L);
        concert.setStatus("open");
        concert.setCity("Madrid");
        concert.setDate(LocalDate.now());
        concert.setLatitude(23124D);
        concert.setShowTitle("Concierto en Las Ventas de Madrid");
        concert.setLongitude(1232D);
        concert.setMusician(new Musician());
        concert.setProvince("Madrid");
        return concert;
    }

    public static Musician testMusician(Boolean correctRequest) {

        if (!correctRequest) {

            List<Work> works = new ArrayList<>();
            List<Claim> claims = new ArrayList<>();
            LocalDate birthDate = LocalDate.of(1992, 1, 1);

            Musician musician = new Musician();
            musician.setFirstName("Pedro");
            musician.setLastName("Sánchez");
            musician.setBirthDate(birthDate);
            musician.setAffiliated(true);
            musician.setDni("459898fffZ");
            musician.setPerformanceFee(2.6f);
            musician.setAffiliatedNumber(12312L);
            musician.setWorks(works);
            musician.setClaims(claims);

            return musician;
        }

        List<Work> works = new ArrayList<>();
        List<Claim> claims = new ArrayList<>();
        LocalDate birthDate = LocalDate.of(1992, 1, 1);

        Musician musician = new Musician();
        musician.setFirstName("Pedro");
        musician.setLastName("Sánchez");
        musician.setBirthDate(birthDate);
        musician.setAffiliated(true);
        musician.setDni("45916040J");
        musician.setPerformanceFee(2.6f);
        musician.setAffiliatedNumber(12312L);
        musician.setWorks(works);
        musician.setClaims(claims);

        return musician;
    }

    public static Document testDocument(Boolean correctRequest) {

        if (!correctRequest) {

            Document document = new Document();
            document.setId(1L);
            document.setCreateAt(LocalDate.now());
            document.setSize(-1L);
            document.setFilename("TestDocument");
            document.setCompletionPercentage(2.3f);
            document.setComplete(true);
            document.setType("");
            document.setClaim(new Claim());
            return document;
        }

        Document document = new Document();
        Claim claim = new Claim();
        claim.setId(1L);

        document.setId(1L);
        document.setCreateAt(LocalDate.now());
        document.setSize(121212L);
        document.setFilename("TestDocument");
        document.setCompletionPercentage(2.3f);
        document.setComplete(true);
        document.setType("");
        document.setClaim(claim);
        return document;

    }

    public static Work testWork(Boolean correctRequest) {

        if (!correctRequest) {
            Work work = new Work();
            work.setId(1L);
            work.setIsrc("");
            work.setDuration(2.3F);
            work.setGenre("test");
            work.setTitle("test");
            work.setComposedAt(LocalDate.now());
            work.setMusicians(new ArrayList<>());

            return work;

        }

        List<Musician> musicians = new ArrayList<>();
        Musician musician = new Musician();
        musician.setId(1L);

        Work work = new Work();
        work.setId(1L);
        work.setIsrc("ESABC2370123");
        work.setDuration(2.3F);
        work.setGenre("test");
        work.setTitle("test");
        work.setComposedAt(LocalDate.now());

        work.setMusicians(musicians);
        musicians.add(musician);

        return work;
    }

}

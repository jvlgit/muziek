package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("select a from Album a join fetch a.artiest")
    List<Album> findAllMetArtiestNaam();



}

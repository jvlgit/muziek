package be.vdab.muziek.repositories;

import be.vdab.muziek.domain.Album;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Override
    @EntityGraph(attributePaths = "artiest")
    List<Album> findAll(Sort sort);

    @EntityGraph(attributePaths = "artiest")
    List<Album> findAlbumsByJaar(int jaar);
}

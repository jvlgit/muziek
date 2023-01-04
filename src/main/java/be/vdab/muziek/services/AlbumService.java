package be.vdab.muziek.services;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.dto.AlbumMetArtiestNaam;
import be.vdab.muziek.repositories.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;
@Service
@Transactional(readOnly = true)
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAllMetArtiestNaam() {
        return albumRepository.findAllMetArtiestNaam();
    }
}

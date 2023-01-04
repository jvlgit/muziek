package be.vdab.muziek.controllers;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.exceptions.ArtiestNietGevondenException;
import be.vdab.muziek.services.ArtiestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("artiesten")
public class ArtiestController {
    private final ArtiestService artiestService;

    public ArtiestController(ArtiestService artiestService) {
        this.artiestService = artiestService;
    }

    @GetMapping("{id}/albums")
    Stream<AlbumNaamEnJaar> findAlbumsByArtiestId(@PathVariable long id) {
        return artiestService.findById(id)
                .map(artiest -> artiest.getAlbums().stream().map(album -> new AlbumNaamEnJaar(album)))
                .orElseThrow(ArtiestNietGevondenException::new);

        }

    private record AlbumNaamEnJaar(String naam, int jaar) {
        AlbumNaamEnJaar(Album album) {
            this(album.getNaam(), album.getJaar());
        }
    }
}

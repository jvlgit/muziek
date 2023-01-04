package be.vdab.muziek.controllers;

import be.vdab.muziek.dto.AlbumMetArtiestNaam;
import be.vdab.muziek.services.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("albums")
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("albums")
    Stream<AlbumMetArtiestNaam> findAlbumsMetArtiestNaam() {
        return albumService.findAllMetArtiestNaam()
                .stream()
                .map(album -> new AlbumMetArtiestNaam(album));
    }
}

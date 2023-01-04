package be.vdab.muziek.controllers;

import be.vdab.muziek.dto.AlbumMetArtiestNaam;
import be.vdab.muziek.dto.Detail;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.services.AlbumService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("albums")
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    Stream<AlbumMetArtiestNaam> findAlbumsMetArtiestNaam() {
        return albumService.findAll()
                .stream()
                .map(album -> new AlbumMetArtiestNaam(album));
    }

    @GetMapping("{id}")
    Detail findById(@PathVariable long id) {
        return albumService.findById(id)
                .map(album -> new Detail(album))
                .orElseThrow(AlbumNietGevondenException::new);
    }

    @GetMapping(params = "jaar")
    Stream<AlbumMetArtiestNaam> findAlbumByJaar(int jaar) {
        return albumService.findAlbumByJaar(jaar)
                .stream()
                .map(album -> new AlbumMetArtiestNaam(album));
    }

    private record ScoreWijziging(@RequestBody @Min(0) @Max(10) int score) {}
    @PatchMapping("{id}/score")
    void wijzigScore(@PathVariable long id, @RequestBody @Valid ScoreWijziging scoreWijziging) {
        albumService.wijzigScore(id, scoreWijziging.score());
    }
}

package be.vdab.muziek.dto;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.domain.Track;

import java.time.LocalTime;
import java.util.Set;

public record Detail(String naam, String artiestNaam, int jaar, String labelNaam, LocalTime tijd, Set<Track> tracks) {
    public Detail(Album album) {
        this(album.getNaam(), album.getArtiest().getNaam(), album.getJaar(), album.getLabel().getNaam(), album.getTijd(),
                album.getTracks());
    }
}

package be.vdab.muziek.dto;

import be.vdab.muziek.domain.Album;

public record AlbumMetArtiestNaam(String naam, String artiestNaam, int jaar) {
    public AlbumMetArtiestNaam(Album album) {
        this(album.getNaam(),album.getArtiest().getNaam(), album.getJaar() );
    }
}

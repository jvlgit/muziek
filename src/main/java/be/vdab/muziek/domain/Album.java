package be.vdab.muziek.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    private long id;
    private String naam;
    private int jaar;
    private long barcode;
    private int score;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "artiestId")
    @JoinColumn(name = "labelId")
    private Artiest artiest;

    @ElementCollection
    @CollectionTable(name = "tracks",
    joinColumns = @JoinColumn(name = "albumId"))
    private Set<Track> tracks;



    public Album(long id, String naam, int jaar, long barcode, int score, Artiest artiest) {
        this.id = id;
        this.naam = naam;
        this.jaar = jaar;
        this.barcode = barcode;
        this.score = score;
        this.artiest = artiest;
    }

    protected Album(){};

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int getJaar() {
        return jaar;
    }

    public long getBarcode() {
        return barcode;
    }

    public int getScore() {
        return score;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }
}

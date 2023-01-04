package be.vdab.muziek.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "artiesten")
public class Artiest {
    @Id
    private long id;
    private String naam;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Album> getAlbums() {
        return Collections.unmodifiableSet(albums);
    }

    @OneToMany(mappedBy = "artiest") @OrderBy("naam")
    private Set<Album> albums;


}

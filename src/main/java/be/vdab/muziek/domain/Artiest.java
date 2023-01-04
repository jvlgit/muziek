package be.vdab.muziek.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
}

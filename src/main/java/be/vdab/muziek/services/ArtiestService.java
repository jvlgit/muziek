package be.vdab.muziek.services;

import be.vdab.muziek.domain.Artiest;
import be.vdab.muziek.repositories.ArtiestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArtiestService {
    private final ArtiestRepository artiestRepository;

    public ArtiestService(ArtiestRepository artiestRepository) {
        this.artiestRepository = artiestRepository;
    }

    public Optional<Artiest> findById(long id) {return artiestRepository.findById(id);}
}

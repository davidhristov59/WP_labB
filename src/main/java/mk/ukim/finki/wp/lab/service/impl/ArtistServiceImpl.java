package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository repository;

    public ArtistServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> listArtists() {
        return repository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository repository;

    public SongServiceImpl(SongRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> listSongs() {
        return repository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return repository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return repository.findByTrackId(trackId);
    }

    @Override
    public List<Song> findSongsByGenre(Genre genre) {
        return repository.searchSongByGenre(genre);
    }
}

package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Song findByTrackId(String trackId){
        return DataHolder.songs.stream()
                .filter(s -> s.getTrackId().equals(trackId))
                .findFirst()
                .orElse(null);
    }

    public Artist addArtistToSong(Artist artist, Song song){

        if(!song.getPerformers().contains(artist)){
            song.getPerformers().add(artist);
        }

        return artist;
    }

    public List<Song> searchSongByGenre(Genre genre){
        return DataHolder.songs.stream()
                .filter(song -> song.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

}

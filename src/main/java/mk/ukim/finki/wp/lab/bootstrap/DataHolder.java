package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static final List<Artist> artists = new ArrayList<>();
    public static final List<Song> songs = new ArrayList<>();

    @PostConstruct
    public void init(){

        artists.add(new Artist(1L, "Black", "Sabbath", "Black Sabbath were an English rock band formed in Birmingham in 1968 by guitarist Tony Iommi, drummer Bill Ward, bassist Geezer Butler, and vocalist Ozzy Osbourne. "));
        artists.add(new Artist(2L, "Led", "Zeppelin", "Led Zeppelin were an English rock band formed in London in 1968. The band comprised Robert Plant, Jimmy Page, John Paul Jones and John Bonham."));
        artists.add(new Artist(3L, "Rolling", "Stones", "The Rolling Stones are an English rock band formed in London in 1962. Active for over six decades, they are one of the most popular and enduring bands of the rock era."));
        artists.add(new Artist(4L, "The", "Beatles", "The Beatles were an English rock band formed in Liverpool in 1960. The core lineup of the band comprised John Lennon, Paul McCartney, George Harrison and Ringo Starr. "));
        artists.add(new Artist(5L, "Pink", "Floyd", "Pink Floyd are an English rock band formed in London in 1965. Gaining an early following as one of the first British psychedelic groups, they were distinguished by their extended compositions, sonic experiments, philosophical lyrics"));

        songs.add(new Song("1", "Paranoid", "Rock", 1996, new ArrayList<>()));
        songs.add(new Song("2", "Immigrant Song", "Rock", 1998, new ArrayList<>()));
        songs.add(new Song("3", "Gimme Shelter", "Rock", 2001, new ArrayList<>()));
        songs.add(new Song("4", "Yesterday", "Rock", 1994, new ArrayList<>()));
        songs.add(new Song("5", "Shine on you Crazy Diamond", "Rock", 1992, new ArrayList<>()));
    }

}

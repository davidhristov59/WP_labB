package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {

    public List<Genre> listGenres(){
        return DataHolder.genres;
    }

}

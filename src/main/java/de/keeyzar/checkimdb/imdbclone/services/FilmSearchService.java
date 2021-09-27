package de.keeyzar.checkimdb.imdbclone.services;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * provide means to find a film based e.g. on name
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FilmSearchService {
    private final FilmRepository filmRepository;

    public List<Film> findFilmByName(String searchString){
        return filmRepository.findByFilmNameContaining(searchString);
    }

    public List<Film> findAllFilms(){
        return filmRepository.findAll();
    }
}

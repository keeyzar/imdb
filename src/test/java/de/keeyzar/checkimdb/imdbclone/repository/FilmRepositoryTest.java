package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static de.keeyzar.checkimdb.imdbclone.testutils.CreateEntities.createFilm;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void givenTwoFilms_whenSearchingForFilmMatchingSingleEntry_thenSingleFilmIsReturned(){
        //given
        Film expectedFilm = filmRepository.save(createFilm("Harry Potter"));
        filmRepository.save(createFilm("other film"));

        //when
        List<Film> films = filmRepository.findByFilmNameContaining("Harry Potter");

        //then
        Assertions.assertThat(films)
                .containsExactly(expectedFilm);
    }

    //could be optimized with Parameterized Tests
    @Test
    public void givenTwoFilms_whenSearchingForSubstringFilmMatchingSingleEntry_thenSingleFilmIsReturned(){
        //given
        Film expectedFilm = filmRepository.save(createFilm("Harry Potter"));
        filmRepository.save(createFilm("other film"));

        //when
        List<Film> films = filmRepository.findByFilmNameContaining("Potter");

        //then
        Assertions.assertThat(films)
                .containsExactly(expectedFilm);
    }

    //could be optimized with Parameterized Tests
    @Test
    public void givenTwoFilms_whenSearchingForSubstringFilmMatchingMultipleEntries_thenMultipleEntriesAreReturned(){
        //given
        Film expectedFilm = filmRepository.save(createFilm("Harry Potter"));
        Film expectedFilmTwo = filmRepository.save(createFilm("other film"));

        //when
        List<Film> films = filmRepository.findByFilmNameContaining("o");

        //then
        Assertions.assertThat(films)
                .containsExactly(expectedFilm, expectedFilmTwo);
    }

}
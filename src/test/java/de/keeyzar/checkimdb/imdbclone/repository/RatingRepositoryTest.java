package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static de.keeyzar.checkimdb.imdbclone.testutils.CreateEntities.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class RatingRepositoryTest {
    @Autowired
    public RatingRepository subject;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public FilmRepository filmRepository;

    @Test
    public void givenSingleRating_whenAskingForAverageRating_thenRatingIsCorrect(){
        //given
        User user = userRepository.save(createUser("kevin", ""));
        Film film = filmRepository.save(createFilm("Harry Potter"));
        subject.save(createRating(user, film, 4.0));
        //when
        Optional<Double> averageRatingForFilm = subject.getAverageRatingForFilm(film.getId());
        //then
        Assertions.assertThat(averageRatingForFilm).contains(4.0);
    }

    @Test
    public void givenMultipleRatings_whenAskingForAverageRating_thenRatingIsCorrect(){
        //given
        User user = userRepository.save(createUser("kevin", ""));
        User secondUser = userRepository.save(createUser("kevin", ""));
        Film film = filmRepository.save(createFilm("Harry Potter"));
        subject.save(createRating(user, film, 4.0));
        subject.save(createRating(secondUser, film, 5.0));
        //when
        Optional<Double> averageRatingForFilm = subject.getAverageRatingForFilm(film.getId());
        //then
        Assertions.assertThat(averageRatingForFilm).contains(4.5);
    }

    @Test
    public void givenZeroRatings_whenAskingForAverageRating_thenRatingIsZero(){
        //given
        Film film = filmRepository.save(createFilm("Harry Potter"));
        //when
        Optional<Double> averageRatingForFilm = subject.getAverageRatingForFilm(film.getId());
        //then
        Assertions.assertThat(averageRatingForFilm).isEmpty();
    }
}
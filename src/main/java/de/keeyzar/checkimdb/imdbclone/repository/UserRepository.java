package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

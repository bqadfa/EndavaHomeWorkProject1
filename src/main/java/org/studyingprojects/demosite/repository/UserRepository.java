package org.studyingprojects.demosite.repository;

import org.springframework.data.repository.CrudRepository;
import org.studyingprojects.demosite.domain.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository {

    Optional<User> findByUsername (String username);

}

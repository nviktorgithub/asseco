package hu.asseco.homework.repository;

import hu.asseco.homework.model.User;
import hu.asseco.homework.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    @Query(value = "SELECT ur FROM UserRole ur where ur.user = ?1")
    Optional<UserRole> findByUser(User user);
}
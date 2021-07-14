package user.repository;

import org.springframework.stereotype.Repository;
import user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

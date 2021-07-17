package user.repository;

import org.springframework.stereotype.Repository;
import user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import user.model.UserInformation;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    Optional<UserInformation> findByMail(String mail);
}

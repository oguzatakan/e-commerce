package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository <UserDetails, Long>{
}

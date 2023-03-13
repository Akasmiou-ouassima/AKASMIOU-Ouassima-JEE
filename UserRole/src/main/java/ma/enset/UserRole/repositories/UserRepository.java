package ma.enset.UserRole.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
  User findByUserName(String Username);
}

package bookmyshow.repositories;

import bookmyshow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findById(long id);
    User save(User user);
}

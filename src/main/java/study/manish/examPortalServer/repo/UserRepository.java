package study.manish.examPortalServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.manish.examPortalServer.model.User;

public interface UserRepository  extends JpaRepository<User,Long> {

    public  User findByUsername(String username);
}

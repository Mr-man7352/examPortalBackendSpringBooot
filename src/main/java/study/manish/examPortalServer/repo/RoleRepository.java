package study.manish.examPortalServer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.manish.examPortalServer.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}

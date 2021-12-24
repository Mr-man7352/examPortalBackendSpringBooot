package study.manish.examPortalServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.manish.examPortalServer.model.Role;
import study.manish.examPortalServer.model.User;
import study.manish.examPortalServer.model.UserRole;
import study.manish.examPortalServer.service.UserService;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {


		SpringApplication.run(ExamPortalServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
//		User user = new User();
//
//		user.setFirstName("Manish");
//		user.setLastName("Sahu");
//		user.setUsername("man7");
//		user.setPassword("man");
//		user.setEmail("man@gmail.com");
//		user.setProfile("default.png");
//
//		Role role1= new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser((user));
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
	}
}

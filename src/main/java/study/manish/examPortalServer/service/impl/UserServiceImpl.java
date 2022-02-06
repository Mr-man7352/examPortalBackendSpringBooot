package study.manish.examPortalServer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.manish.examPortalServer.helper.UserFoundException;
import study.manish.examPortalServer.model.User;
import study.manish.examPortalServer.model.UserRole;
import study.manish.examPortalServer.repo.RoleRepository;
import study.manish.examPortalServer.repo.UserRepository;
import study.manish.examPortalServer.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    createing user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

       User local = this.userRepository.findByUsername(user.getUsername());
       if (local != null){
           System.out.println("User already exist!!");
//           throw new Exception("User already exist!!");
           throw new UserFoundException();
       } else {
//           create user
           for(UserRole ur:userRoles){
               roleRepository.save(ur.getRole());
           }
           user.getUserRoles().addAll(userRoles);
           local=this.userRepository.save(user);
       }
        return local;
    }

//    get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

//    delete user by id
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}

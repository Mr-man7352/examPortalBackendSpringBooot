package study.manish.examPortalServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import study.manish.examPortalServer.config.JwtUtils;
import study.manish.examPortalServer.model.JwtRequest;
import study.manish.examPortalServer.model.JwtResponse;
import study.manish.examPortalServer.model.User;
import study.manish.examPortalServer.service.impl.UserDetailsServiceImpl;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

//    generate token
@PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }
//        user is now authenticated
        UserDetails userDetails= this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER DISABLED" + e.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials" + e.getMessage());
        }
    }

//    returns the details of the current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
    return  ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }

}

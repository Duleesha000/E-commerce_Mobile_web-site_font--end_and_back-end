package userservice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import userservice.model.User;
import userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return null;
        }
        else if(userRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        //Set the user's password to the hashed password.
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public boolean updatePassword(String username, String password, String newPassword) {
        System.out.println(username);
        User user = userRepository.findByUsername(username);
        System.out.println(user.toString());

        //handles the comparison for us
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //allow change is current password matches existing one, AND if new password is not the same as old password
        try {
            if (passwordEncoder.matches(password, user.getPassword()) && !password.equals(newPassword)) {
                //allow change
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return true; //success

            } else {
                return false; //fail
            }
        }
        catch(Exception e) {
            return false;
        }
    }

    public boolean login(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
        catch(Exception e) {
            return false;
        }

    }


}

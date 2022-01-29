package com.example.demo.auth;

import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List <ApplicationUser> getApplicationUsers (){

        List<User> users = userRepository.findAll();
        List<ApplicationUser> applicationUsers = new ArrayList<>();

        for (User user : users) {

          ApplicationUser appUser =  new ApplicationUser();
          appUser.setUsername(user.getUsername());

            appUser.setPassword(user.getPassword());
            passwordEncoder.encode(appUser.getPassword());

            if(user.getIsAdmin()){
             appUser.setGrantedAuthorities(ADMIN.getGrantedAuthorities());

          } else {
              appUser.setGrantedAuthorities(EMPLOYEE.getGrantedAuthorities());
          }
          appUser.setAccountNonExpired(true);
          appUser.setAccountNonLocked(true);
          appUser.setCredentialsNonExpired(true);
          appUser.setEnabled(true);
          applicationUsers.add(appUser);
        }
        return applicationUsers;
    }


}

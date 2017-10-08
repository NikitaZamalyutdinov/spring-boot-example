package server.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.domain.UserRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        server.domain.User user =  userRepository.findByName(username).get();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getName(), user.getPassword(), Sets.newHashSet(new SimpleGrantedAuthority("USER")));
    }
}

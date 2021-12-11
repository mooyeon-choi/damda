package damda.back.service;

import damda.back.dto.JwtRequestDto;
import damda.back.entity.Users;
import damda.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.get(username);
        if (user != null) {
            return new User(user.getId(), user.getPw(), AuthorityUtils.NO_AUTHORITIES);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public void save(JwtRequestDto user){
        Users newUser= new Users();
        newUser.setId(user.getUsername());
        newUser.setPw(bcryptEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
    }
}

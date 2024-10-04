package com.pmh.ex10.login;

import com.pmh.ex10.user.User;
import com.pmh.ex10.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void join(JoinDto joinDto) {
        User user = modelMapper.map(joinDto, User.class);
        // username -> name
        user.setName(joinDto.getUsername());
        // 암호화...
        user.setPassword(
                passwordEncoder.encode(joinDto.getPassword())
        );
//        user.setRole("ROLE_USER");
        user.setRole("ROLE_ADMIN");

        User dbUser = userRepository.save(user);
        System.out.println(dbUser);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("일로오냐");
        return org.springframework.security.core.userdetails.User
                .builder()
                .username("asdf")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();
    }
}


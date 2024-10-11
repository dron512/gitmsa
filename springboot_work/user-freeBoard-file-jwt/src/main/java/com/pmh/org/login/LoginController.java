package com.pmh.org.login;

import com.pmh.org.user.User;
import com.pmh.org.user.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto){
        loginService.join(joinDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/login")
    public String redirectWithPost(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );

        System.out.println("암호화한 패스워드 = ");
        String encodedPassword = passwordEncoder.encode(password);
        String dbPassword = user.getPassword();

        boolean isMatch = passwordEncoder.matches(dbPassword, encodedPassword);
        System.out.println("isMatch = "+ isMatch);

        return "토큰 만들계획";
    }
}

package com.shop.auth;

import com.shop.auth.model.AuthenticationResponse;
import com.shop.auth.jwt.JwtService;
import com.shop.user.dto.UserLoginDTO;
import com.shop.user.dto.UserRegisterDTO;
import com.shop.user.model.User;
import com.shop.user.model.Role;
import com.shop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(UserLoginDTO userLoginDTO) throws Exception {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                userLoginDTO.getEmail(),
                userLoginDTO.getPassword()
            )
        );


        var user = userRepository.findByEmail(userLoginDTO.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(UserRegisterDTO userRegisterDTO) {
        var user = User.builder()
                .name(userRegisterDTO.getName())
                .surname(userRegisterDTO.getSurname())
                .email(userRegisterDTO.getEmail())
                .password(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

package com.duxsoftware.pruebatecnica.auth;

import com.duxsoftware.pruebatecnica.users.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.duxsoftware.pruebatecnica.jwt.JwtService;
import com.duxsoftware.pruebatecnica.users.User;
import com.duxsoftware.pruebatecnica.users.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        String token = jwtService.getToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER) // Asumiendo que tienes una enumeración de roles
                .build();

        userRepository.save(user);
        String token = jwtService.getToken(user);
        return new AuthResponse(token);
    }
}

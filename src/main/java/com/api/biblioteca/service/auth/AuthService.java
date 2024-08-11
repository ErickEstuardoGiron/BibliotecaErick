package com.api.biblioteca.service.auth;

import com.api.biblioteca.config.JwtService;
import com.api.biblioteca.dto.auth.AuthDto;
import com.api.biblioteca.dto.auth.LoginDto;
import com.api.biblioteca.dto.auth.RegisterDto;
import com.api.biblioteca.entity.UserMongoEntity;
import com.api.biblioteca.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserMongoRepository userMongoRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthDto login(LoginDto loginDto) {
        Optional<UserMongoEntity> userOptional = userMongoRepository.findByEmail(loginDto.getUsername());

        if (userOptional.isEmpty()) {
            return null; // User not found
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en la autenticacion", e);
        }

        UserMongoEntity user = userOptional.get();
        String token = jwtService.getToken(user);

        return new AuthDto(token);
    }


    public AuthDto register(RegisterDto registerDto) {
        validateRegisterDto(registerDto);

        Optional<UserMongoEntity> existingUser = userMongoRepository.findByEmail(registerDto.getEmail());

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe en la base de datos");
        }

        UserMongoEntity newUser = new UserMongoEntity();
        newUser.setName(registerDto.getName());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        try {
            userMongoRepository.save(newUser);
        } catch (Exception e) {
            throw new RuntimeException("Error during saving user", e);
        }

        String token = jwtService.getToken(newUser);

        return new AuthDto(token);
    }


    private void validateRegisterDto(RegisterDto registerDto) {
        if (registerDto.getPassword() == null || registerDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password no es valida");
        }

        if (registerDto.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password es muy corta");
        }

        if (registerDto.getEmail() == null || registerDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email no es el correcto");
        }

        if (registerDto.getName() == null || registerDto.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre no es correcto");
        }
    }

}

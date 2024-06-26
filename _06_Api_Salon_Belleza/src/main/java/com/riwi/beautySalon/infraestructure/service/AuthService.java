package com.riwi.beautySalon.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginReq;
import com.riwi.beautySalon.api.dto.request.RegisterReq;
import com.riwi.beautySalon.api.dto.response.AuthResp;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UserRepository;
import com.riwi.beautySalon.infraestructure.abstract_services.IAuthService;
import com.riwi.beautySalon.infraestructure.helpers.JWTService;
import com.riwi.beautySalon.utils.enums.Role;
import com.riwi.beautySalon.utils.exception.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JWTService jwtService;

    @Override
    public AuthResp login(LoginReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public AuthResp register(RegisterReq request) {
        // 1. Validar que el usuario no exista
        User exist = this.findByUserName(request.getUserName());
        if (exist != null) {
            throw new BadRequestException("Este nombre de usuario ya esta registrado");
        }

        User user = User
                .builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .role(Role.CLIENT)
                .build();
        this.userRepository.save(user);
        return AuthResp
                .builder()
                .message("Se registro exitosamente")
                .token(this.jwtService.getToken(user))
                .build();
    }

    private User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName).orElse(null);
    }

}

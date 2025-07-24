package com.leandroleiteh.services;

import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;

public interface JwtValidationService {

    boolean validateJwt(final JwtInput jwtInput);
}

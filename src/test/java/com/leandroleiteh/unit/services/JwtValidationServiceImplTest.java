package com.leandroleiteh.unit.services;

import com.leandroleiteh.services.impl.JwtValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;

import static com.leandroleiteh.ConstantUtilsTest.JWT.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JwtValidationServiceImplTest {

    private JwtValidationServiceImpl jwtValidationServiceImpl;

    @BeforeEach
    void setUp() {
        jwtValidationServiceImpl = new JwtValidationServiceImpl();
    }

    @Test
    void shouldReturnTrue_forValidToken() {
        JwtInput input = new JwtInput().jwt(TOKEN_VALID);
        assertTrue(jwtValidationServiceImpl.validateJwt(input));
    }

    @Test
    void shouldReturnFalse_forMalformedToken() {
        JwtInput input = new JwtInput().jwt(NOT_A_JWT);
        assertFalse(jwtValidationServiceImpl.validateJwt(input));
    }

    @Test
    void shouldReturnFalse_forInvalidFormatToken() {
        JwtInput input = new JwtInput().jwt(TOKEN_INVALID_FORMAT);
        assertFalse(jwtValidationServiceImpl.validateJwt(input));
    }

    @Test
    void shouldReturnFalse_whenNameContainsDigit() {
        JwtInput input = new JwtInput().jwt(TOKEN_INVALID_NAME);
        assertFalse(jwtValidationServiceImpl.validateJwt(input));
    }

    @Test
    void shouldReturnFalse_whenExtraClaimPresent() {
        JwtInput input = new JwtInput().jwt(TOKEN_EXTRA_CLAIM);
        assertFalse(jwtValidationServiceImpl.validateJwt(input));
    }
}

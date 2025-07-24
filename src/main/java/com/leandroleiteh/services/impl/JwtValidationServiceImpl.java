package com.leandroleiteh.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.leandroleiteh.enums.Claims;
import com.leandroleiteh.services.JwtValidationService;
import jakarta.enterprise.context.ApplicationScoped;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class JwtValidationServiceImpl implements JwtValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtValidationServiceImpl.class);

    private static final Set<String> EXPECTED_KEYS =
            Stream.of(Claims.values())
                    .map(Claims::getKey)
                    .collect(Collectors.toSet());


    private static final Predicate<Map<String,String>> JWT_VALIDATION_RULES = map ->
            map != null
                    && map.keySet().equals(EXPECTED_KEYS)
                    && Claims.Name.test(map.get(Claims.Name.getKey()))
                    && Claims.Role.test(map.get(Claims.Role.getKey()))
                    && Claims.Seed.test(map.get(Claims.Seed.getKey()));

    @Override
    public boolean validateJwt(final JwtInput jwtInput) {

        try {

            DecodedJWT jwt = JWT.decode(jwtInput.getJwt());

            Map<String,String> rawClaims = extractClaims(jwt);
            LOGGER.debug("Raw claims payload: {}", rawClaims);

            if (!JWT_VALIDATION_RULES.test(rawClaims)) {
                LOGGER.info("JWT inválido: chaves={}, valores={}", rawClaims.keySet(), rawClaims);
                return false;
            }

            LOGGER.info("JWT válido: chaves={}, valores={}", rawClaims.keySet(), rawClaims);
            return true;

        } catch (JWTDecodeException e) {
            LOGGER.error("Erro ao decodificar/validar JWT: {}", e.getMessage());
            return false;
        }
    }

    private Map<String,String> extractClaims(final DecodedJWT jwt) {
        return jwt.getClaims().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().asString()
                ));
    }
}
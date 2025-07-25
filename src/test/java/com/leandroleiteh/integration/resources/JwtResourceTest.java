package com.leandroleiteh.integration.resources;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.swagger_codegen_backend_challenge_yaml.model.JwtInput;

import java.util.stream.Stream;

import static com.leandroleiteh.ConstantUtilsTest.JWT.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class JwtResourceTest {

    private static final String URL = "/api/v1/jwt/validate";

    static Stream<String> invalidTokens() {
        return Stream.of(
                TOKEN_INVALID_FORMAT,
                TOKEN_INVALID_NAME,
                TOKEN_EXTRA_CLAIM,
                NOT_A_JWT
        );
    }

    @ParameterizedTest(name = "invalid token «{0}» should return 400 + \"falso\"")
    @MethodSource("invalidTokens")
    void invalidTokensShouldReturn400(String token) {
        if (token == null) {
            given()
                    .when()
                    .post(URL)
                    .then()
                    .statusCode(400);
        } else {
            given()
                    .contentType(ContentType.JSON)
                    .body(new JwtInput().jwt(token))
                    .when()
                    .post(URL)
                    .then()
                    .statusCode(400)
                    .contentType(ContentType.JSON)
                    .body("valid", is("falso"));
        }
    }

    @Test
    void validTokenShouldReturn200() {
        given()
                .contentType(ContentType.JSON)
                .body(new JwtInput().jwt(TOKEN_VALID))
                .when()
                .post(URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("valid", is("verdadeiro"));
    }
}

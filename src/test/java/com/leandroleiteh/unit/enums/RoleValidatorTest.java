package com.leandroleiteh.unit.enums;

import com.leandroleiteh.enums.RoleValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.leandroleiteh.ConstantUtilsTest.RoleClaim.INVALID_ROLE_IS_EMPTY;
import static com.leandroleiteh.ConstantUtilsTest.RoleClaim.INVALID_ROLE_IS_NULL;
import static org.junit.jupiter.api.Assertions.*;

class RoleValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"ADMIN","MEMBER","EXTERNAL"})
    void validRolesShouldPass(String role) {
        assertTrue(RoleValidator.INSTANCE.isValidClaim(role));
    }

    @ParameterizedTest
    @ValueSource(strings = {"NONE","SOME","INVALID"})
    void invalidRolesShouldFail(String role) {
        assertFalse(RoleValidator.INSTANCE.isValidClaim(role));
    }

    @Test
    void shouldReturnFalse_WhenRoleIsNull() {
        assertFalse(RoleValidator.INSTANCE.isValidClaim(INVALID_ROLE_IS_NULL));
    }

    @Test
    void shouldReturnFalse_WhenRoleIsEmpty() {
        assertFalse(RoleValidator.INSTANCE.isValidClaim(INVALID_ROLE_IS_EMPTY));
    }
}
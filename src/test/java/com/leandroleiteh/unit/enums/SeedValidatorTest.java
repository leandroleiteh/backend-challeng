package com.leandroleiteh.unit.enums;

import com.leandroleiteh.enums.SeedValidator;
import org.junit.jupiter.api.Test;

import static com.leandroleiteh.ConstantUtilsTest.SeedClaim.*;
import static org.junit.jupiter.api.Assertions.*;

class SeedValidatorTest {

    @Test
    void shouldReturnTrue_WhenSeedIsValid() {
        assertTrue(SeedValidator.INSTANCE.isValidClaim(SEED_VALID));
    }

    @Test
    void shouldReturnFalse_WhenSeedIsNotPrime() {
        assertFalse(SeedValidator.INSTANCE.isValidClaim(SEED_INVALID));
    }

    @Test
    void shouldReturnFalse_WhenSeedIsNull() {
        assertFalse(SeedValidator.INSTANCE.isValidClaim(SEED_INVALID_IS_NULL));
    }

    @Test
    void shouldReturnFalse_WhenSeedIsEmpty() {
        assertFalse(SeedValidator.INSTANCE.isValidClaim(SEED_INVALID_IS_EMPTY));
    }

    @Test
    void shouldFalse_WhenSeedIsNotNumber() {
        assertFalse(SeedValidator.INSTANCE.isValidClaim(SEED_INVALID_IS_NOT_NUMBER));
    }
}
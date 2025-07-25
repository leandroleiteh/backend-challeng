package com.leandroleiteh.unit.enums;

import com.leandroleiteh.enums.NameValidator;
import org.junit.jupiter.api.Test;

import static com.leandroleiteh.ConstantUtilsTest.NameClaim.*;
import static org.junit.jupiter.api.Assertions.*;

class NameValidatorTest {

    @Test
    void shouldReturnTrue_WhenNameIsValid() {
        assertTrue(NameValidator.INSTANCE.isValidClaim(NAME_VALID));
    }

    @Test
    void shouldReturnFalse_WhenNameContainsInvalidCharacters() {
        assertFalse(NameValidator.INSTANCE.isValidClaim(NAME_INVALID_WITH_NUMBERS));
    }

    @Test
    void shouldReturnFalse_WhenNameIsEmpty() {
        assertFalse(NameValidator.INSTANCE.isValidClaim(NAME_INVALID_IS_EMPTY));
    }

    @Test
    void shouldReturnFalse_WhenNameIsNull() {
        assertFalse(NameValidator.INSTANCE.isValidClaim(NAME_INVALID_IS_NULL));
    }

    @Test
    void shouldReturnFalse_WhenNameIsTooLong() {
        var name = "A".repeat(MAX_SIZE_LENGTH + 1);
        assertFalse(NameValidator.INSTANCE.isValidClaim(name));
    }
}

package com.leandroleiteh.enums;

import com.leandroleiteh.validators.ClaimValidator;

public enum NameValidator implements ClaimValidator {
    INSTANCE;

    public static final int MAX_SIZE_LENGTH = 256;

    public boolean isValidClaim(String claimValue) {
        return claimValue != null
                && !claimValue.isEmpty()
                && claimValue.length() <= MAX_SIZE_LENGTH
                && claimValue.chars().allMatch(t-> Character.isLetter(t) || Character.isSpaceChar(t));
    }
}

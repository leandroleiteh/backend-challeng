package com.leandroleiteh.enums;

import com.leandroleiteh.validators.ClaimValidator;

import java.util.Set;

public enum RoleValidator implements ClaimValidator {

    INSTANCE;

    private static final Set<String> ALLOWED_ROLES = Set.of("ADMIN", "MEMBER", "EXTERNAL");

    @Override
    public boolean isValidClaim(String claimValue) {
        return claimValue != null
                && !claimValue.isEmpty()
                && ALLOWED_ROLES.contains(claimValue.toUpperCase());
    }
}
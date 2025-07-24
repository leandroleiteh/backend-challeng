package com.leandroleiteh.validators;

@FunctionalInterface
public interface ClaimValidator {

    boolean isValidClaim(final String claimValue);
}

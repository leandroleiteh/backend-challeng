package com.leandroleiteh.enums;

import com.leandroleiteh.validators.ClaimValidator;

public enum SeedValidator implements ClaimValidator {
    INSTANCE;

    @Override
    public boolean isValidClaim(String claimValue) {
        return claimValue != null &&
                !claimValue.isEmpty() &&
                isPrime(Integer.parseInt(claimValue));
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

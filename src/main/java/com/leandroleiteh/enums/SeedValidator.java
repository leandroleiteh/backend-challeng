package com.leandroleiteh.enums;

import com.leandroleiteh.validators.ClaimValidator;

public enum SeedValidator implements ClaimValidator {
    INSTANCE;

    @Override
    public boolean isValidClaim(String claimValue) {
        if (claimValue == null || claimValue.isEmpty()) {
            return false;
        }
        try {
            int n = Integer.parseInt(claimValue);
            return isPrime(n);
        } catch (NumberFormatException e) {
            return false;
        }
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

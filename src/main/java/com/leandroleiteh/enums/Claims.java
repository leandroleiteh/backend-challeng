package com.leandroleiteh.enums;

import com.leandroleiteh.validators.ClaimValidator;

import java.util.function.Predicate;

public enum Claims {

    Name("Name", NameValidator.INSTANCE),
    Role("Role", RoleValidator.INSTANCE),
    Seed("Seed", SeedValidator.INSTANCE);

    private final String key;
    private final Predicate<String> validator;

    Claims(String key, ClaimValidator validator) {
        this.key = key;
        this.validator = validator::isValidClaim;
    }

    public String getKey() {
        return key;
    }

    public boolean test(String raw) {
        return validator.test(raw);
    }
}


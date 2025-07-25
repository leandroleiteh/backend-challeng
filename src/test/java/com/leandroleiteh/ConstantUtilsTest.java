package com.leandroleiteh;

public class ConstantUtilsTest {

    public static class NameClaim {

        public static final int MAX_SIZE_LENGTH = 256;
        public static final String NAME_VALID = "Toninho Araujo";
        public static final String NAME_INVALID_WITH_NUMBERS = "M4ria Olivia";
        public static final String NAME_INVALID_IS_EMPTY = "";
        public static final String NAME_INVALID_IS_NULL = null;
    }

    public static class RoleClaim {

        public static final String INVALID_ROLE_IS_NULL = null;
        public static final String INVALID_ROLE_IS_EMPTY = "";
    }

    public static class SeedClaim {

        public static final String SEED_VALID = "7";
        public static final String SEED_INVALID = "8";
        public static final String SEED_INVALID_IS_NULL = null;
        public static final String SEED_INVALID_IS_EMPTY = "";
        public static final String SEED_INVALID_IS_NOT_NUMBER = "ABC";
    }

    public static class JWT {

        public static final String TOKEN_VALID ="eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
        public static final String TOKEN_INVALID_FORMAT = "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
        public static final String TOKEN_INVALID_NAME = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";
        public static final String TOKEN_EXTRA_CLAIM = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";
        public static final String NOT_A_JWT = "not.a.jwt";
    }
}

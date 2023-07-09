package domain;

import java.util.logging.Level;

public enum UserLevel {
    BASIC(1), SILVER(2), GOLD(3);

    private final int level;

    UserLevel(int level) {
        this.level = level;
    }

    public int intValue() {
        return this.level;
    }

    public static UserLevel valueOf(int level) {
        for (UserLevel userLevel : values()) {
            if(userLevel.level == level) {
                return userLevel;
            }
        }

        throw new AssertionError("Unknown value : " + level);
    }
}

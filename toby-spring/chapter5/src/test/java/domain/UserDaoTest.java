package domain;

import org.junit.jupiter.api.BeforeEach;

class UserDaoTest {

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        this.user1 = new User("gyumee", "박성철", "springno1", UserLevel.BASIC, 1, 0);
        this.user2 = new User("leegw700", "이길원", "springno1", UserLevel.BASIC, 1, 0);
        this.user3 = new User("gyumee", "박성철", "springno1", UserLevel.BASIC, 1, 0);
    }
}

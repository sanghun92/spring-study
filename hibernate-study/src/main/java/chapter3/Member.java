package chapter3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @Column(name = "id")
    private Long id;

    @Column
    private String username;

    protected Member() {

    }

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "chapter3.Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public void changeUserName(String username) {
        this.username = username;
    }
}

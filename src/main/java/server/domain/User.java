package server.domain;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String shortName;
    private String avatar;

    public User() {
    }

    public User(String name, String password, String shortName, String avatar) {
        this.name = name;
        this.password = password;
        this.shortName = shortName;
        this.avatar = avatar;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package server.Data;

public class User {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}

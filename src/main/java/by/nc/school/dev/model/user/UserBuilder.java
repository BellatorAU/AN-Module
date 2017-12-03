package by.nc.school.dev.model.user;

public class UserBuilder {
    private User user = new User();

    public User build() {
        return user;
    }

    public UserBuilder setLogin(String userName) {
        user.setUsername(userName);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

}

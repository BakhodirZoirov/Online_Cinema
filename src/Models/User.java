package Models;
import Enums.Role;

import java.math.BigDecimal;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private Role role;

    private int balance;
    public static int currId=1;
    {
        currId++;
    }

    public User(int id, String name, String login, String password, Role role, int balance) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public static int getCurrId() {
        return currId;
    }

    public static void setCurrId(int currId) {
        User.currId = currId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && login.equals(user.login) && password.equals(user.password) && role == user.role && balance==(user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, role, balance);
    }
}

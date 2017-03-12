package ua.litovka.dto;

import ua.litovka.model.Entity;
import ua.litovka.model.Role;

import java.time.LocalDate;

/**
 * Created by SergLion on 22.02.2017.
 */
public class UserDTO extends Entity<Integer> {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private LocalDate birthday;
    private RoleDTO role;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String firstName, String lastName, String email, String sex, LocalDate birthday, RoleDTO role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.role = role;
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

    public void setPassword(String paassword) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", role=" + role +
                "} " + super.toString();
    }
}

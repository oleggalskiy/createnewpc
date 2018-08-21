package by.epam.labproject.createmypc.domain;

import java.util.Optional;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String password;
    private boolean active;

    private Optional<String> name;
    private Optional<String> surname;
    private Optional<String> age;
    private Optional<String> address;
    private Optional<String> email;



    private Set<Role> roles;



    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(String name) { this.name = Optional.ofNullable(name);
    }

    public Optional<String> getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = Optional.ofNullable(surname);
    }

    public Optional<String> getAge() {
        return age;
    }

    public void setAge(String age) { this.age = Optional.ofNullable(age);
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = Optional.ofNullable(address);
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
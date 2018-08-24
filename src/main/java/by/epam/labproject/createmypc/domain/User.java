package by.epam.labproject.createmypc.domain;

import java.util.Set;

public class User {
    private  Long id;
    private final String username;
    private final String password;
    private final boolean active;

    private final String firstname;
    private final String surname;
    private final String age;
    private final String address;
    private final String email;

    private  Set<Role> roles;

    public User(
        final Long newId,
        final String newUsername,
        final String newPassword,
        final boolean newActive,

        final String newFirstname,
        final String newSurname,
        final String newAge,
        final String newAdress,
        final String newEmail,

        final Set<Role> newRoles)   {
        this.id = newId;
        this.username = newUsername;
        this.password = newPassword;
        this.active = newActive;
        this.firstname = newFirstname;
        this.surname = newSurname;
        this.age = newAge;
        this.address = newAdress;
        this.email = newEmail;
        this.roles = newRoles;
    }

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

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public String getFirstname() { return firstname != null ? firstname: "<none>";
    }

    public String getSurname() { return surname != null ? surname: "<none>";
    }

    public String getAge() { return age != null ? age: "<none>";
    }

    public String getAddress() { return address != null ? address: "<none>";
    }

    public String getEmail() { return email != null ? email: "<none>" ;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public static class Builder {
        private Long nestedId;
        private String nestedUsername;
        private String nestedPassword;
        private boolean nestedActive;

        private String nestedFirstname;
        private String nestedSurname;
        private String nestedAge;
        private String nestedAddress;
        private String nestedEmail;
        private Set<Role> nestedRoles;

        public Builder setId(Long nestedId) {
            this.nestedId = nestedId;
            return this;
        }

        public Builder setUsername(String nestedUsername) {
            this.nestedUsername = nestedUsername;
            return this;
        }

        public Builder setPassword(String nestedPassword) {
            this.nestedPassword = nestedPassword;
            return this;
        }

        public Builder setActive(boolean nestedActive) {
            this.nestedActive = nestedActive;
            return this;
        }

        public Builder setFirstname(String nestedFirstname) {
            this.nestedFirstname = nestedFirstname;
            return this;
        }

        public Builder setSurname(String nestedSurname) {
            this.nestedSurname = nestedSurname;
            return this;
        }

        public Builder setAge(String nestedAge) {
            this.nestedAge = nestedAge;
            return this;
        }

        public Builder setAddress(String nestedAddress) {
            this.nestedAddress = nestedAddress;
            return this;
        }

        public Builder setEmail(String nestedEmail) {
            this.nestedEmail = nestedEmail;
            return this;
        }

        public Builder setRoles(Set<Role> nestedRoles) {
            this.nestedRoles = nestedRoles;
            return this;
        }

        public User build() {
            return new User(nestedId, nestedUsername, nestedPassword, nestedActive,
                    nestedFirstname, nestedSurname, nestedAge, nestedAddress,
                    nestedEmail, nestedRoles);
        }

    }
    public static  Builder newBuilder(){
        return new Builder();
    }
}













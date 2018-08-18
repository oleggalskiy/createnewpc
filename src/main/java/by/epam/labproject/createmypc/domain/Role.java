package by.epam.labproject.createmypc.domain;

public enum Role {
    USER, ADMIN;


    public String getAuthority() {
        return name();
    }
}

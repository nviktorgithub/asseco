package hu.asseco.homework.dto;

import hu.asseco.homework.model.Role;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String address;
    //further class variables
    private Role role;

    public UserDto() {
    }

    public UserDto(Long id, String username, String email, String address, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

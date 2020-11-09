package hu.asseco.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES")
public class UserRole extends AbstractTable {

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
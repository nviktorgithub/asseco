package hu.asseco.homework.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User extends AbstractTable {

    private boolean active;
    private String address;
    private Long created;
    private Date createdAt;
    private Long deleted;
    private Date deletedAt;
    private boolean deletedFlag;
    private String email;
    private String emailToken;
    private Date lastLogin;
    private String name;
    private Date nextLoginChangePwd;
    private String password;
    private Date passwordExpired;
    private String phone;
    private String settlementId;
    private String tempPassword;
    private Date tempPasswordExpired;
    private Long updated;
    private Date updatedAt;
    private String userType;
    private String username;
    private String settlementsBySettlementId;
    private Long userByCreatedId;
    private Long userByDeletedId;
    private Long userByUpdatedId;
    private String token;

    @OneToOne(mappedBy = "user")
    private UserRole userRole;

    public User() {}

    public User(String username, String password, String email, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailToken() {
        return emailToken;
    }

    public void setEmailToken(String emailToken) {
        this.emailToken = emailToken;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNextLoginChangePwd() {
        return nextLoginChangePwd;
    }

    public void setNextLoginChangePwd(Date nextLoginChangePwd) {
        this.nextLoginChangePwd = nextLoginChangePwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Date passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public Date getTempPasswordExpired() {
        return tempPasswordExpired;
    }

    public void setTempPasswordExpired(Date tempPasswordExpired) {
        this.tempPasswordExpired = tempPasswordExpired;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSettlementsBySettlementId() {
        return settlementsBySettlementId;
    }

    public void setSettlementsBySettlementId(String settlementsBySettlementId) {
        this.settlementsBySettlementId = settlementsBySettlementId;
    }

    public Long getUserByCreatedId() {
        return userByCreatedId;
    }

    public void setUserByCreatedId(Long userByCreatedId) {
        this.userByCreatedId = userByCreatedId;
    }

    public Long getUserByDeletedId() {
        return userByDeletedId;
    }

    public void setUserByDeletedId(Long userByDeletedId) {
        this.userByDeletedId = userByDeletedId;
    }

    public Long getUserByUpdatedId() {
        return userByUpdatedId;
    }

    public void setUserByUpdatedId(Long userByUpdatedId) {
        this.userByUpdatedId = userByUpdatedId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return username.equals(user.username) &&
                password.equals(user.password);
        //further validations...
    }
}
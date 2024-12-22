
package model;

public class User {
    private int userID;
    private int roleID;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String phoneNumber;
    private String address;

    public User() {
    }

    public User(int userID, int roleID, String username, String password, String email, String fullName, String phoneNumber, String address) {
        this.userID = userID;
        this.roleID = roleID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", roleID=" + roleID + ", username=" + username + ", password=" + password + ", email=" + email + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
    }

    
}

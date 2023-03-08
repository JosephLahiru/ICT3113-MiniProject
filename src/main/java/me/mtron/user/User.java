package me.mtron.user;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String email;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String nickname;
    @Column(name = "profile_picture")
    private String profilePicture;

    public User() {
    }

    public User(int user_id, String email, String userName, String password, String nickname, String profilePicture) {
        this.user_id = user_id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
        this.profilePicture = profilePicture;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

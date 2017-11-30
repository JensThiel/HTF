package team.rats.HTF.models;


import access.Admin;
import org.springframework.data.annotation.Id;

public class User {

    @Admin
    @Id
    private String userName;

    @Admin
    private String password;


    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }



    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }
}
package utility;

import Enums.UserType;

public abstract class User {

    private String name ;
    private static int counter =0 ;
    private int id ;
    private String phone ;
    private String email ;
    private UserType type ;
    public User(String name,  String phone, String email) {
        counter++ ;
        this.name = name ;
        this.id = counter ;
        this.phone = phone ;
        this.email = email ;
    }
    public void setType(UserType type){
        this.type = type;
    }
    public abstract String getType();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

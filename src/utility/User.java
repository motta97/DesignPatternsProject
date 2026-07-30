package utility;

public class User {

    private String name ;
    private static int counter =0 ;
    private int id ;
    private String phone ;
    private String email ;

    public User(String name,  String phone, String email) {
        counter++ ;
        this.name = name ;
        this.id = counter ;
        this.phone = phone ;
        this.email = email ;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

package DonationManagement;

public class User {
   private String name ;
   private int id ;
   private String phone ;
   private String email ;

    public User(String name, int id, String phone, String email) {
        this.name = name ;
        this.id = id ;
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

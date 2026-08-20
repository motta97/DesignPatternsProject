package utility;

public class Admin extends User{

    public Admin(String name, String phone, String email) {
        super(name, phone, email);
    }

    @Override
    public String getType() {
        return "Admin";
    }
}

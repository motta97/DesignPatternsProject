package utility;

public class normalUser extends User{

    public normalUser(String name, String phone, String email) {
        super(name, phone, email);
    }

    @Override
    public String getType() {
        return "Normal";
    }
}

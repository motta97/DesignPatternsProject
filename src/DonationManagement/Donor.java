package DonationManagement;
import utility.User ;

public abstract class Donor extends User {
    public Donor(String name ,  String phone , String email){
        super(name,phone,email);

    }

    public abstract String getDescription() ;
    public abstract String showBenefits() ;
    @Override
    public String toString() {
        return "Donor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", benefits='" + showBenefits() + '\'' +
                '}';
    }
}

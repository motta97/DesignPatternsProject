package DonationManagement;

public abstract class Donor extends User {
    public Donor(String name , int id , String phone , String email){
        super(name,id,phone,email);

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

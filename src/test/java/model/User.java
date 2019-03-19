package model;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String mobilPhone;


    public User(String name, String lastName, String email, String password, String address,
                String city, String state, String postalCode, String mobilPhone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.mobilPhone = mobilPhone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

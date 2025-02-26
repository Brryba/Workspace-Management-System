package services.users;

public class Customer extends User {
    private String name;

    public String getName() {
        return this.name;
    }

    public Customer(String name) {
        this.name = name;
    }
}

package workplaces;

import java.math.BigDecimal;

public class Workplace {
    private int ID;
    private String type;
    private BigDecimal price;
    private boolean isAvailable;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Workplace ID: " + this.ID +
                "\nType: " + this.type +
                "\nPrice: " + this.price +
                "\nAvailability Status: " + (isAvailable ? "Available" : "Not Available");
    }
}

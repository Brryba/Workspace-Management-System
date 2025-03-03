package services.workspaces;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Workspace {
    private int ID;
    private String type;
    private BigDecimal price;
    private boolean isAvailable = true;

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
        this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_DOWN);
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "Workplace ID: " + this.ID +
                "\nType: " + this.type +
                "\nPrice: " + this.price +
                "\nAvailability Status: " + (isAvailable ? "Available" : "Not Available\n");
    }
}

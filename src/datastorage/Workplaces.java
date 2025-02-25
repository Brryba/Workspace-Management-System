package datastorage;

import workplaces.Workplace;

import java.util.ArrayList;

public class Workplaces extends ArrayList<Workplace> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append(i + 1).append(") ").append(this.get(i).toString());
        }
        return sb.toString();
    }
}

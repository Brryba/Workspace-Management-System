package services.workspaces;

import UI.interfaces.Applyable;
import datastorage.MainStorage;
import datastorage.Workspaces;

import java.util.Scanner;

public class WorkspaceAdder implements Applyable {
    private Workspace assignWorkPlace() {
        Workspace workplace = new Workspace();
        Scanner scanner = MainStorage.scanner;

        System.out.println("Enter workspace ID:");
        workplace.setID(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter workspace type:");
        workplace.setType(scanner.nextLine());

        System.out.println("Enter workspace price:");
        workplace.setPrice(Double.parseDouble(scanner.nextLine()));

        return workplace;
    }

    @Override
    public void apply() {
        Workspaces workplacesList = MainStorage.workspaces;
        workplacesList.add(assignWorkPlace());
    }

    @Override
    public String getMethodName() {
        return "Add a new coworking space";
    }
}

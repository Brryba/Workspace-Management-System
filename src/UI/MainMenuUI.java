package UI;

public class MainMenuUI implements BaseUI {
    @Override
    public void printAllMethods() {
        for (Methods method : Methods.values()) {
            System.out.println(method.toString());
        }
    }

    @Override
    public void selectMethod(int methodIndex) {
        Methods method =
    }

    private enum Methods {
        ADMIN(1, "Admin Login"),
        CUSTOMER(2, "Customer Login"),
        QUIT(0, "Quit");

        private final String methodTitle;
        private final int methodID;

        Methods(int methodId, String methodTitle) {
            this.methodTitle = methodTitle;
            this.methodID = methodId;
        }

        @Override
        public String toString() {
            return this.methodID + " - " + this.methodTitle;
        }
    }
}

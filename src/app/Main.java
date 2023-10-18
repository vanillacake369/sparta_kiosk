package app;

public class Main {
    public static void main(String[] args) {
        try (Application application = Application.getInstance()) {
            while (true) {
                application.runKiosk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
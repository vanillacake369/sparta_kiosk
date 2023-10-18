package app;

public class Application {
    private static Application instance;

    private Application() {}

    public static Application getInstance(){
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    public void runKiosk(){

    }
}

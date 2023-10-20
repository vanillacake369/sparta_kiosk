package app;

public class Main {
    public static void main(String[] args) {
        // 앱 싱글톤 객체의 키오스크 실행함수를 무한 호출하고, 빠져나오면 메모리 해제를 합니다.
        try (Application application = Application.getInstance()) {
            while (true) {
                application.runKiosk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
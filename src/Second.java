
class Robot {
    private Thread moveLeftThread;
    private Thread moveRightThread;

    Robot() {
        moveLeftThread = new Thread(() -> {
            while (true) {
                System.out.println("left");
                try {
                    Thread.sleep(2000); // Пауза 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        moveRightThread = new Thread(() -> {
            while (true) {
                System.out.println("right");
                try {
                    Thread.sleep(2000); // Пауза 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void startRight() {
        moveRightThread.start();
    }

    public void startLeft() {
        moveLeftThread.start();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class Second {
    public static void main(String[] args) throws InterruptedException {
        Robot robot = new Robot();
        robot.startRight();
        robot.pause(1000);
        robot.startLeft();
    }
}

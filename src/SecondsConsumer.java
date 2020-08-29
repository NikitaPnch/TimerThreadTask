public class SecondsConsumer extends Thread {

    private final TimerProducer timer;
    private final int step;

    public SecondsConsumer(TimerProducer timer, int step) {
        this.timer = timer;
        this.step = step;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (timer) {
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    System.out.println("SecondsConsumer InterruptedException");
                    e.printStackTrace();
                }
                System.out.println(timer.getSeconds());
            }
        }
    }
}

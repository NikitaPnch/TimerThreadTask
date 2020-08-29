public class SecondsConsumer extends Thread {

    private final TimerProducer timer;

    public SecondsConsumer(TimerProducer timer) {
        this.timer = timer;
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

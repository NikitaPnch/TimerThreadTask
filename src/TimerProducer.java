public class TimerProducer extends Thread {

    private final int period;
    private int seconds = 0;

    public TimerProducer(int period) {
        this.period = period;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(period + 1000);
                synchronized (this) {
                    seconds++;
                    this.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("TimerProducer InterruptedException");
                e.printStackTrace();
            }
        }
    }
}

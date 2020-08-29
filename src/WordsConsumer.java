import java.util.List;

public class WordsConsumer extends Thread {

    private final List<String> listWords;
    private final int step;
    private final TimerProducer timerProducer;

    public WordsConsumer(List<String> listWords, int step, TimerProducer timerProducer) {
        this.listWords = listWords;
        this.step = step;
        this.timerProducer = timerProducer;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            synchronized (timerProducer) {
                try {
                    timerProducer.wait();
                    if (timerProducer.getSeconds() % step == 0) {
                        try {
                            System.out.println(listWords.get(index));
                            index++;
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("WordsConsumer InterruptedException");
                    e.printStackTrace();
                }
            }
        }
    }
}

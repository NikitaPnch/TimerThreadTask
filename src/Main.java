import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TimerProducer timerProducer = new TimerProducer(1);

        List<String> listWords = new ArrayList<>();
        listWords.add("один");
        listWords.add("два");
        listWords.add("три");
        listWords.add("четыре");
        listWords.add("пять");
        listWords.add("шесть");
        listWords.add("семь");
        listWords.add("восемь");

        SecondsConsumer secondsConsumer = new SecondsConsumer(timerProducer, 1);
        WordsConsumer wordsConsumer = new WordsConsumer(listWords, 5, timerProducer);
        WordsConsumer wordsConsumerSecond = new WordsConsumer(listWords, 7, timerProducer);

        timerProducer.start();
        secondsConsumer.start();
        wordsConsumer.start();
        wordsConsumerSecond.start();
    }
}

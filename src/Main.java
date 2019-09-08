import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(8);
        Semaphore ticketWindow = new Semaphore(4);
        System.out.println("Автококзал. Рейс Бишкек-ОШ. ");
        for (int i = 1; i <=8; i++){
            new Passenger(ticketWindow, i, countDownLatch).start();

        } while (countDownLatch.getCount()>7){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } System.out.println("Автобус с пассажирами выезжает в ОШ. ");
    }
}

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore ticketWindow;
    CountDownLatch countDownLatch;
    int id;

    Passenger(Semaphore ticketWindow, int id, CountDownLatch countDownLatch) {
        this.ticketWindow = ticketWindow;
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
                countDownLatch.countDown();
                countDownLatch.await();
                sleep(500);
                ticketWindow.acquire();
                System.out.println("Пассажир " + id + " заходит в кассу ");

                sleep(500);

                System.out.println("Пассажир " + id + " купил билет и выходит из кассы");
                ticketWindow.release();
                sleep(500);

                System.out.println("Пассажир " + id + " сел в автобус");
                sleep(500);

                System.out.println("Пассажир " + id + " ждет в автобусе");
                sleep(500);


        } catch (InterruptedException e) {
            System.out.println("У пассажира " + id + " нету денег ");
        }
    }
}


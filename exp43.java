import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private int availableSeats = 5;
    private final Lock lock = new ReentrantLock();

    public void bookTicket(String customer, int seats) {
        lock.lock();
        try {
            if (seats <= availableSeats) {
                System.out.println(customer + " booked " + seats + " seat(s).");
                availableSeats -= seats;
            } else {
                System.out.println(customer + " tried to book " + seats + " seats but only " + availableSeats + " are available.");
            }
        } finally {
            lock.unlock();
        }
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem system;
    private final String customer;
    private final int seats;

    BookingThread(TicketBookingSystem system, String customer, int seats, int priority) {
        this.system = system;
        this.customer = customer;
        this.seats = seats;
        this.setPriority(priority);
    }

    public void run() {
        system.bookTicket(customer, seats);
    }
}

public class exp43 {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        BookingThread vip1 = new BookingThread(system, "VIP Customer 1", 2, Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP Customer 2", 2, Thread.MAX_PRIORITY);
        BookingThread normal1 = new BookingThread(system, "Normal Customer 1", 1, Thread.MIN_PRIORITY);
        BookingThread normal2 = new BookingThread(system, "Normal Customer 2", 2, Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
    }
}

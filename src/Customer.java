import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Booking booking = new Booking();
        System.out.println("Call taxi booking application");
        while(true){
            System.out.println("Enter your choice");
            System.out.println("1.Booking");
            System.out.println("2.Taxi Details");
            System.out.println("3.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.println("Enter the Customer ID");
                    int customerId = sc.nextInt();
                    System.out.println("Enter the pickup point");
                    char pickUpPoint = sc.next().charAt(0);
                    System.out.println("Enter the drop point");
                    char dropPoint = sc.next().charAt(0);
                    System.out.println("Enter the pickup time");
                    int pickUpTime = sc.nextInt();

                    if (pickUpPoint < 'A' || pickUpPoint > 'F' || dropPoint < 'A' || dropPoint > 'F') {
                        System.out.println("Valid pickup and drop are A, B, C, D, E, F. Exiting");
                        break;
                    }
                    List<Taxi> freeTaxis = booking.getFreeTaxis(pickUpTime, pickUpPoint);

                    if (freeTaxis.size() == 0) {
                        System.out.println("Sorry!! All The Taxis Are Busy");
                        System.out.println("Your Booking Was Cancelled");
                        break;
                    }
                    Collections.sort(freeTaxis, (a, b) -> a.totalEarnings - b.totalEarnings);
                    booking.bookTaxi(customerId, pickUpPoint, dropPoint, pickUpTime, freeTaxis);
                }
                case 2 -> {
                    booking.displayDetails();
                }
                case 3 -> {
                    System.exit(0);
                }
                default -> {
                    return;
                }
            }
        }
    }
}

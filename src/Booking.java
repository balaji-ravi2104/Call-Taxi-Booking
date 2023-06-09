import java.util.ArrayList;
import java.util.List;

public class Booking {
    List<Taxi> taxis;
    public Booking(){
       taxis = Taxi.createTaxi(4);
    }
    public List<Taxi> getFreeTaxis(int pickUpTime,char pickUpPoint){
        List<Taxi> freeTaxis = new ArrayList<Taxi>();
        for(Taxi t : taxis){
            if(t.freeTime <= pickUpTime && (Math.abs((t.currentPoint-'0') - (pickUpPoint-'0')) <= pickUpTime - t.freeTime)){
                freeTaxis.add(t);
            }
        }
        return freeTaxis;
    }

    public void bookTaxi(int id, char pickUpPoint, char dropPoint, int pickUpTime, List<Taxi> freeTaxis) {
        int mini = Integer.MAX_VALUE;
        int distanceBetweenPickUpAndDrop = 0;
        int earning = 0;
        int nextFreeTime = 0;
        char nextSpot = '#';
        // Object for Taxi class
        Taxi bookedtaxi = null;
        String tripDetails = "";
        for(Taxi t : freeTaxis){
            int distanceBetweenCustomerAndTaxi = Math.abs((pickUpPoint-'0') - (t.currentPoint-'0'))*15;
            if(distanceBetweenCustomerAndTaxi < mini){
                bookedtaxi = t;
                distanceBetweenPickUpAndDrop = Math.abs((pickUpPoint-'0') - (dropPoint-'0'))*15;
                earning = (distanceBetweenPickUpAndDrop-5)*10+100;
                int dropTime = pickUpTime + distanceBetweenPickUpAndDrop/15;
                nextFreeTime = dropTime;
                nextSpot = dropPoint;
                tripDetails = id + "               " + id + "          " + pickUpPoint +  "      " + dropPoint + "       " + pickUpTime + "          " +dropTime + "           " + earning;
                mini = distanceBetweenCustomerAndTaxi;
            }
        }
            bookedtaxi.setDetails(true, nextSpot, nextFreeTime, bookedtaxi.totalEarnings + earning, tripDetails);
            System.out.println("Taxi " + bookedtaxi.id + " Booked");
    }

    public void displayDetails(){
        for(Taxi t:taxis){
            t.printTaxiDetails();
        }
        System.out.println();
        for(Taxi t:taxis){
            t.printDetails();
        }
        System.out.println();
    }

}

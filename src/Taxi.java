import java.util.ArrayList;
import java.util.List;

public class Taxi {
    static List<Taxi> taxis = new ArrayList<Taxi>();
    int id;
    static int taxiCount=0;
    boolean booked;
    char currentPoint;
    int freeTime;
    int totalEarnings;
    List<String> trips;

    public Taxi(){
        booked = false;
        currentPoint = 'A';
        freeTime = 0;
        totalEarnings = 0;
        trips = new ArrayList<String>();
        taxiCount = taxiCount+1;
        id=taxiCount;
    }
    public static List<Taxi> createTaxi(int n) {
        for (int i = 1; i <=n; i++) {
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }

    public void setDetails(boolean booked,char currentPoint,int freeTime,int totalEarnings,String tripDetails){
        this.booked = booked;
        this.currentPoint = currentPoint;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        this.trips.add(tripDetails);
    }

    public void printDetails(){
        System.out.println("Taxi - "+this.id + " Total Earning - "+this.totalEarnings);
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String trip : trips){
            System.out.println(id +"              "+trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void printTaxiDetails(){
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarnings + " Current spot - " + this.currentPoint +" Free Time - " + this.freeTime);
    }
}

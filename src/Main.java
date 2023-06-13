public class Main {
    public static void main(String[] args) throws Exception {
        Vehicle v = new Vehicle("SUV","Innova","MH04L1874B");
        Coordinate x = new Coordinate(10,7);
        Coordinate y =  new Coordinate(8,20);
        Passenger p = new Passenger("Someone","H3ll0W0Rld",x);
        System.out.println(p.toString()+"\nRequests booking:-");
        p.createUser();
        System.out.println("\nBooking cost :"+p.requestBooking(x,y,"SUV"));
        System.out.println("\nBooking is stored in the Requests Arraylist: "+Booking.Requests.get(0));
        CabDriver c = new CabDriver("Someone1","H3ll0W0Rld",x,v);
        c.createUser();
        System.out.println(c.toString()+"\nSearches for a Booking :-");
        System.out.println("\nGets Booking :"+c.getNewBooking().toString());
        System.out.println("\nBooking is stored in the Active Arraylist: "+Booking.Active.get(0));
        System.out.println("\nThe driver finishes the ride and gets payment: "+c.finishRide());
        System.out.println("\nThe Completed booking is stored in the Completed Arraylist: "+Booking.Completed.get(0));
        System.out.println("\nPassenger in the Passengers arraylist:\n"+Users.Passengers.get(0));
        System.out.println("\nCab Driver in the CabDrivers arraylist:\n"+Users.CabDrivers.get(0));
    }
}
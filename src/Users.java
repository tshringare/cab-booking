import java.util.ArrayList;

public abstract class Users{
    public static ArrayList<Passenger> Passengers = new ArrayList<>();
    public static ArrayList<CabDriver> CabDrivers = new ArrayList<>() ;
    String username;
    String password;
    Coordinate location;

    public boolean validatePass(String p){
        if(p.length() < 8){
            return false;}
        Character ch;
        int counter = 0;
        for(int i = 0 ; i<p.length() ;i++){
            ch = p.charAt(i);
            if (!(!Character.isLetter(ch) || !Character.isDigit(ch))){
                return false;
            }
            else if(Character.isDigit(ch)){
                counter += 1;
            }
        }
        if(counter<=2){
            return false;
        }
        return true;
    }


    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public void setCredentials(String username,String password) throws Exception {
        if (validatePass(password)){
            this.password = password;
        }
        else{
            System.out.println(password);
            throw new Exception("Invalid Password, Password should be 8 characters long, contain at least 2 digits " +
                    "and not include non-numeric or non-alphabetical values");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Users(String username, String password, Coordinate location) throws Exception {
        setCredentials(username, password);
        setLocation(location);
    }

    abstract void createUser();

    @Override
    public String toString() {
        return "Users{" +
                "\nusername='" + getUsername() + '\'' +
                "\n, password='" + getPassword() + '\'' +
                "\n, location=" + getLocation().toString() +
                '}';
    }
}
class Passenger extends Users{

    public Passenger(String username, String password, Coordinate location) throws Exception {
        super(username, password, location);
    }

    @Override
    public void createUser() {
        Passengers.add(this);
    }


    public double requestBooking(Coordinate start, Coordinate end,String v_type) throws Exception {
        for(int i = 0; i < Booking.Requests.size(); i++){
            if(Booking.Requests.get(i).getPassenger() == this){
                throw new Exception("A Passenger cannot request multiple bookings");
            }
        }
        for(int i = 0; i < Booking.Active.size(); i++){
            if(Booking.Active.get(i).getPassenger() == this){
                throw new Exception("A Passenger cannot have multiple active bookings");
            }
        }
        Booking b =  new Booking(start,end,this,v_type);
        Booking.Requests.add(b);
        return b.getCost();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class CabDriver extends Users{

    Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public CabDriver(String username, String password, Coordinate location,Vehicle vehicle) throws Exception {
        super(username, password, location);
        setVehicle(vehicle);
    }

    public Booking getNewBooking() throws Exception {
        for(int i = 0; i < Booking.Active.size(); i++){
            if(Booking.Active.get(i).getDriver() == this){
                throw new Exception("A Driver cannot have multiple active bookings");
            }
        }
        double min = -1;
        Booking booking = Booking.Requests.get(0);
        for(int i = 0; i < Booking.Requests.size();i++){
            if(min == -1 || min > Booking.Requests.get(i).getStart().getDist(this.getLocation()) &&
                    Booking.Requests.get(i).getCarType() == this.getVehicle().getType()){
                min = Booking.Requests.get(i).getStart().getDist(this.getLocation());
                booking = Booking.Requests.get(i);
            }
            booking.setDriver(this);
            booking.setStatus(true);
            Booking.Requests.remove(booking);
            Booking.Active.add(booking);
        }
        return booking;
    }
    public double finishRide() throws Exception{
        boolean flag = false;
        Booking booking = null;
        for(int i = 0; i < Booking.Active.size(); i++){
            if(Booking.Active.get(i).getDriver() == this){
                booking = Booking.Active.get(i);
                flag = true;
                break;
            }
        }
        if(flag){
            Booking.Active.remove(booking);
            Booking.Completed.add(booking);
            return booking.getCost();
        }
        else{
            throw new Exception("This driver has no active rides.");
        }
    }
    @Override
    public void createUser() {
        CabDrivers.add(this);
    }

    @Override
    public String toString() {
        return "CabDriver{" +
                "vehicle=" + getVehicle().toString() +
                "\n, username='" + getUsername() + '\'' +
                "\n, password='" + getPassword() + '\'' +
                "\n, location=" + getLocation().toString() +
                '}';
    }
}

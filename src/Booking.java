import java.util.ArrayList;

class Booking{
    Coordinate start;
    String carType;
    Coordinate end;
    boolean accepted = false;
    Passenger passenger;
    CabDriver driver;

    double cost;
    public static ArrayList<Booking> Requests = new ArrayList<>();
    public static ArrayList<Booking> Active = new ArrayList<>();
    public static ArrayList<Booking> Completed = new ArrayList<>() ;

    public void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }
    public void setDriver(CabDriver driver){
        this.driver = driver;
    }

    public void setStartAndEnd(Coordinate start,Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public void setStatus(boolean accepted) {
        this.accepted = accepted;
    }

    public void setCarType(String carType) throws Exception {
        if(carType == "SUV"|| carType == "Sedan" || carType == "Hatchback"){
            this.carType = carType;
        }
        else{
            throw new Exception("Invalid Vehicle Type");
        }
    }

    public String getCarType() {
        return carType;
    }

    public Booking(Coordinate start, Coordinate end, Passenger passenger, String carType) throws Exception {
        setCarType(carType);
        setPassenger(passenger);
        setStartAndEnd(start,end);
        calculateCost();
    }

    public void calculateCost(){
        if(getCarType() == "SUV"){
            cost = 18*getStart().getDist(getEnd());
        }
        else if (getCarType() == "Sedan") {
            cost = 14*getStart().getDist(getEnd());
        } else if (getCarType() == "Hatchback") {
            cost = 10*getStart().getDist(getEnd());
        }
    }
    public Coordinate getEnd() {
        return end;
    }

    public CabDriver getDriver() {
        return driver;
    }

    public Coordinate getStart() {
        return start;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        if (isAccepted()){
            return "Booking{" +
                    "start=" + getStart().toString() +
                    "\n, carType='" + getCarType() + '\'' +
                    "\n, end=" + getEnd().toString() +
                    "\n, accepted=" + isAccepted() +
                    "\n, passenger=" + getPassenger().toString() +
                    "\n, driver=" + getDriver().toString() +
                    "\n, cost=" + getDriver() +
                    '}';
        }
        return "Booking{" +
                "start=" + getStart().toString() +
                "\n, carType='" + getCarType() + '\'' +
                "\n, end=" + getEnd().toString() +
                "\n, passenger=" + getPassenger().toString() +
                "\n, cost=" + getCost() +
                '}';
    }
}


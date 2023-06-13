import static java.lang.Math.pow;
import static java.lang.Math.round;

class Coordinate{
    double x;
    double y;

    public Coordinate(double x,double y){
        setX(x);
        setY(y);
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double getDist(Coordinate a){
        return round(pow(pow(getX() - a.x,2) + pow(getY() - a.y,2),0.5));
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}

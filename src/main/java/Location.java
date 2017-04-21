/**
 * Created by kevinturan
 */

public class Location {

    private double[] location;

    // Constructor
    public Location(double[] location){
        this.location = location;
    }

    public double[] getLocation(){
        return location;
    }

    public void setLocation(double[] location){
        this.location = location;
    }
}
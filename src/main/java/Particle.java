/**
 * Created by kevinturan on 21/04/2017.
 */
public class Particle {

    private double fitnessVal;
    private Velocity velocity;
    private Location location;

    public Particle(){

    }

    public Particle(double fitnessVal, Velocity velocity, Location location){
        this.fitnessVal = fitnessVal;
        this.velocity = velocity;
        this.location = location;
    }

    public Velocity getVelocity(){
        return velocity;
    }

    public void setVelocity(Velocity velocity){
        this.velocity = velocity;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public double getFitnessVal(){
        fitnessVal = Problem.evaluate(location);
        return fitnessVal;
    }
}
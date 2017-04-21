import java.util.Random;
import java.util.Vector;

/**
 * Created by kevinturan
 */
public class Swarm {
    private int swarmSize = 10;
    private int maxIteration = 100;

    //Function a
    // private int pDimension = 2;

    //Function b
    private int pDimension = 4;
    private double C1 = 2.0;
    private double C2 = 2.0;
    private final double W_UPPERBOUND = 1.0;
    private final double W_LOWERBOUND = 0.0;
    private Vector<Particle> swarm = new Vector();


    Random generator = new Random();


    public void initializeSwarm() {
        Particle p;
        for(int i=0; i<swarmSize; i++) {
            p = new Particle();


            double[] loc = new double[pDimension];
            loc[0] = Problem.LOC_X_LOW + generator.nextDouble() * (Problem.LOC_X_HIGH - Problem.LOC_X_LOW);
            loc[1] = Problem.LOC_Y_LOW + generator.nextDouble() * (Problem.LOC_Y_HIGH - Problem.LOC_Y_LOW);
            //Function b
            loc[2] = Problem.LOC_Y_LOW + generator.nextDouble() * (Problem.LOC_Y_HIGH - Problem.LOC_Y_LOW);
            loc[3] = Problem.LOC_Y_LOW + generator.nextDouble() * (Problem.LOC_Y_HIGH - Problem.LOC_Y_LOW);
            Location location = new Location(loc);


            double[] vel = new double[pDimension];
            vel[0] = Problem.VEL_LOW + generator.nextDouble() * (Problem.VEL_HIGH - Problem.VEL_LOW);
            vel[1] = Problem.VEL_LOW + generator.nextDouble() * (Problem.VEL_HIGH - Problem.VEL_LOW);
            //Function b
            vel[2] = Problem.VEL_LOW + generator.nextDouble() * (Problem.VEL_HIGH - Problem.VEL_LOW);
            vel[3] = Problem.VEL_LOW + generator.nextDouble() * (Problem.VEL_HIGH - Problem.VEL_LOW);
            Velocity velocity = new Velocity(vel);

            p.setLocation(location);
            p.setVelocity(velocity);
            swarm.add(p);
        }
    }


    public Swarm() {
    }

    public int getSwarmSize() {
        return swarmSize;
    }

    public void setSwarmSize(int swarmSize) {
        this.swarmSize = swarmSize;
    }

    public Vector<Particle> getSwarm() {
        return swarm;
    }

    public int getMaxIteration() {
        return maxIteration;
    }

    public int getpDimension() {
        return pDimension;
    }

    public double getC1() {
        return C1;
    }

    public double getC2() {
        return C2;
    }

    public double getW_UPPERBOUND() {
        return W_UPPERBOUND;
    }

    public double getW_LOWERBOUND() {
        return W_LOWERBOUND;
    }




}
/**
 * Created by kevinturan
 */
import java.util.Random;
import java.util.Vector;

public class Process {

    Swarm swarm = new Swarm();

    double[] pBest = new double[swarm.getSwarmSize()];
    private Vector<Location> pBestLocation = new Vector<Location>();
    private double gBest;
    private Location gBestLocation;
    private double[] fitnessValueList = new double[swarm.getSwarmSize()];

    Random generator = new Random();



    public void run(){
        swarm.initializeSwarm();
        updateFitness();
        for(int i=0; i<swarm.getSwarmSize(); i++) {
            pBest[i] = fitnessValueList[i];
            pBestLocation.add(swarm.getSwarm().get(i).getLocation());
        }

        int t = 0;
        double w;
        double err = 9999;

        while(t < swarm.getMaxIteration() && err > Problem.ERR_TOLERANCE) {
            // updating pBest
            for(int i=0; i<swarm.getSwarmSize(); i++) {
                if(fitnessValueList[i] < pBest[i]) {
                    pBest[i] = fitnessValueList[i];
                    pBestLocation.set(i, swarm.getSwarm().get(i).getLocation());
                }
            }

            // updating gBest
            int bestParticleIndex = Util.getMinPos(fitnessValueList);
            if(t == 0 || fitnessValueList[bestParticleIndex] < gBest) {
                gBest = fitnessValueList[bestParticleIndex];
                gBestLocation = swarm.getSwarm().get(bestParticleIndex).getLocation();
            }

            w = swarm.getW_LOWERBOUND() - (((double) t) / swarm.getMaxIteration()) * (swarm.getW_UPPERBOUND() - swarm.getW_LOWERBOUND());

            for(int i=0; i<swarm.getSwarmSize(); i++) {
                double r1 = generator.nextDouble();
                double r2 = generator.nextDouble();

                Particle p = swarm.getSwarm().get(i);

                //updating velocity
                double[] newVel = new double[swarm.getpDimension()];
                newVel[0] = (w * p.getVelocity().getPosition()[0]) +
                        (r1 * swarm.getC1() ) * (pBestLocation.get(i).getLocation()[0] - p.getLocation().getLocation()[0]) +
                        (r2 * swarm.getC2()) * (gBestLocation.getLocation()[0] - p.getLocation().getLocation()[0]);
                newVel[1] = (w * p.getVelocity().getPosition()[1]) +
                        (r1 * swarm.getC1()) * (pBestLocation.get(i).getLocation()[1] - p.getLocation().getLocation()[1]) +
                        (r2 * swarm.getC2()) * (gBestLocation.getLocation()[1] - p.getLocation().getLocation()[1]);
                //b
                newVel[2] = (w * p.getVelocity().getPosition()[2]) +
                        (r1 * swarm.getC1()) * (pBestLocation.get(i).getLocation()[2] - p.getLocation().getLocation()[2]) +
                        (r2 * swarm.getC2()) * (gBestLocation.getLocation()[2] - p.getLocation().getLocation()[2]);
                newVel[3] = (w * p.getVelocity().getPosition()[3]) +
                        (r1 * swarm.getC1()) * (pBestLocation.get(i).getLocation()[3] - p.getLocation().getLocation()[3]) +
                        (r2 * swarm.getC2()) * (gBestLocation.getLocation()[3] - p.getLocation().getLocation()[3]);
                Velocity vel = new Velocity(newVel);
                p.setVelocity(vel);

                //updating location
                double[] newLoc = new double[swarm.getpDimension()];
                newLoc[0] = p.getLocation().getLocation()[0] + newVel[0];
                newLoc[1] = p.getLocation().getLocation()[1] + newVel[1];
                //b
                newLoc[2] = p.getLocation().getLocation()[2] + newVel[2];
                newLoc[3] = p.getLocation().getLocation()[3] + newVel[3];
                Location loc = new Location(newLoc);
                p.setLocation(loc);
            }

            err = Problem.evaluate(gBestLocation) - 0;


            System.out.println("ITERATION " + t + ": ");
            System.out.println("X: " + gBestLocation.getLocation()[0]);
            System.out.println("Y: " + gBestLocation.getLocation()[1]);
            System.out.println("U: " + gBestLocation.getLocation()[2]);
            System.out.println("W: " + gBestLocation.getLocation()[3]);
            System.out.println("Value: " + Problem.evaluate(gBestLocation));

            t++;
            updateFitness();
        }

        System.out.println("\nSolution found at iteration " + (t - 1) + ", the solutions is:");
        System.out.println("X: " + gBestLocation.getLocation()[0]);
        System.out.println("Y: " + gBestLocation.getLocation()[1]);
        //b
        System.out.println("U: " + gBestLocation.getLocation()[2]);
        System.out.println("W: " + gBestLocation.getLocation()[3]);
        System.out.println("Value: " + Problem.evaluate(gBestLocation));
    }

    public void updateFitness(){
        for (int i = 0; i <swarm.getSwarmSize(); i++) {
            fitnessValueList[i] = swarm.getSwarm().get(i).getFitnessVal();
        }
    }
}
/**
 * Created by kevinturan
 */


public class Problem {



    public static final double LOC_X_LOW = -2;
    public static final double LOC_X_HIGH = 2;

    public static final double LOC_Y_LOW = -2;
    public static final double LOC_Y_HIGH = 2;

    public static final double LOC_Z_LOW = 2;
    public static final double LOC_Z_HIGH = -2;

    public static final double LOC_W_LOW = -2;
    public static final double LOC_W_HIGH = 2;

    public static final double VEL_LOW = -2;
    public static final double VEL_HIGH = -2;

    public static final double ERR_TOLERANCE = 1E-20;

    public static double evaluate(Location location){
        double result = 0;
        double x = location.getLocation()[0];
        double y = location.getLocation()[1];
        double z = location.getLocation()[2];
        double w = location.getLocation()[3];

        // Calculation a
        //result = x * Math.exp(-x * x - y * y);

        // Calculation b
        result = 2 * x * Math.exp(-x * x - y * y - (z-1)*(z-1) - w * w);

        return result;
    }
}
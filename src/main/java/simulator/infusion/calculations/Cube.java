package simulator.infusion.calculations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * See http://opentci.org/doku.php?id=code:ccode:cube
 */
public class Cube
{
    private static final double TO_RADIAN = Math.asin(1D) * 2D / 180D;

    private Cube()
    {
    }

    public static List<Double> solve(
        final double k10, final double k12, final double k21, final double k13, final double k31)
    {
        double a0, a1, a2;
        double p, q;
        double phi;
        double r1;
        ArrayList<Double> R = new ArrayList<>(3);

        if (k31 > 0D)
        {
            a0 = k10 * k21 * k31;
            a1 = k10 * k31 +
                k21 * k31 +
                k21 * k13 +
                k10 * k21 +
                k31 * k12;
            a2 = k10 + k12 + k13 + k21 + k31;

            p = a1 - (a2 * a2 / 3D);
            q = (2D * a2 * a2 * a2 / 27D) - (a1 * a2 / 3D) + a0;
            r1 = Math.sqrt(-(p * p * p) / 27D);
            phi = (-q / 2D) / r1;
            if (phi > 1D) phi = 1D;
            else if (phi < -1D) phi = -1D;
            phi = (Math.acos(phi) / 3D);
            r1 = 2.0 * Math.exp(Math.log(r1) / 3D);
            R.add(-(Math.cos(phi) * r1 - a2 / 3D));
            R.add(-(Math.cos(phi + 120D * TO_RADIAN) * r1 - a2 / 3D));
            R.add(-(Math.cos(phi + 240D * TO_RADIAN) * r1 - a2 / 3D));
        } else
        {
            if (k21 > 0D)
            {
                a0 = k10 * k21;
                a1 = -(k10 + k12 + k21);
                R.add((-a1 + Math.sqrt(a1 * a1 - 4 * a0)) / 2D);
                R.add((-a1 - Math.sqrt(a1 * a1 - 4 * a0)) / 2D);
                R.add(0D);
            } else
            {
                R.add(k10);
                R.add(0D);
                R.add(0D);
            }
        }
        Collections.sort(R);
        return R;
    }
}

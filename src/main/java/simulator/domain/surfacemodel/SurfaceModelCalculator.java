package simulator.domain.surfacemodel;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import simulator.common.DataPair;
import simulator.common.util.DoubleUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Juan Camilo Rada
 *
 * Surface model calculator. Generate the pnr, and drug concentration data.
 *
 * Remifentanil and Propofol surface model calculator. The surface model calculates the PN (No response probability)
 * based on Remifentanil and Propofol concentrations.
 * <p/>
 * z(x, y) = (εxy)^ γ / 1 + (εxy)^ γ
 * <p/>
 * z(x, y) = (0.0828 * x * y)^ 5.1550 / 1 + (0.0828 * x * y)^ 5.1550
 * <p/>
 * x: Remifentanil. The Remifentanil concentration μg/ml.
 * y: Propofol. The propofol concentration ng/ml
 * <p/>
 * z(x,y) = z: The no response probability.
 */
public class SurfaceModelCalculator
{
    private static double EPSILON = 0.0828d;
    private static double GAMMA = 5.1550d;

    private static double MAX_VALUE = 10.0;
    private static double INTERVAL = 0.01;
    private static int DECIMAL_POINTS = 2;

    /* PNR by x and y */
    private static Table<Double, Double, Double> pnrDataTable;

    /* X by Y and pnr */
    private static Table<Double, Double, Double> xDataTable;

    /* Y by X and pnr */
    private static Table<Double, Double, Double> yDataTable;

    /* min Y and min X  by PNR by*/
    private static HashMap<Double, DataPair> minPnrMap;

    static
    {
        int size = (int) (MAX_VALUE / INTERVAL);

        pnrDataTable = HashBasedTable.create(size, size);
        xDataTable = HashBasedTable.create(size, size);
        yDataTable = HashBasedTable.create(size, size);
        minPnrMap = new HashMap((int)size * size);

        for (Double x = 0.0; x < MAX_VALUE; x += INTERVAL)
        {
            for (Double y = 0.0; y < MAX_VALUE; y += INTERVAL)
            {
                double pnr = DoubleUtil.roundDouble(caculatePNR(x, y), 2);
                updateDataTable(x, y, pnr);
            }
        }
    }

    /**
     * @param x the Remifentanil concentration μg/ml.
     * @param y The Propofol concentration ng/ml.
     * @return The no response probability.
     */
    public static double caculatePNR(final double x, final double y)
    {
        double operand = Math.pow(x * y * EPSILON, GAMMA);
        double z = operand / (1 + operand);
        return DoubleUtil.roundDouble(z, DECIMAL_POINTS);
    }

    public static double getPNR(final double x, final double y)
    {
        return pnrDataTable.get(x, y);
    }

    public static double getX(final double y, final double pnr)
    {
        return xDataTable.get(y, pnr);
    }

    public static double getY(final double x, final double pnr)
    {
        return xDataTable.get(x, pnr);
    }

    public static DataPair getMinXY(final double pnr)
    {
        return minPnrMap.get(pnr);
    }

    public static List<Double> caculateListPNR(final List<Double> xValues, final List<Double> yValues)
    {
        int dataSize = xValues.size();

        List<Double> result = new ArrayList<>(dataSize);
        for (int i = 0; i < dataSize; i++)
        {
            result.add(caculatePNR(xValues.get(i), yValues.get(i)));
        }

        return result;
    }

    /**
     * return the pnr different values for testing proporse.
     *
     * @return
     */
    static Set<Double> getPossiblesPNR()
    {
        return Sets.newTreeSet(pnrDataTable.values());
    }

    private static void updateDataTable(final double x, final double y, final double pnr)
    {
        double roundedX = DoubleUtil.roundDouble(x, DECIMAL_POINTS);
        double roundedY = DoubleUtil.roundDouble(y, DECIMAL_POINTS);
        double roundedPNR = DoubleUtil.roundDouble(pnr, DECIMAL_POINTS);

        pnrDataTable.put(roundedX, roundedY, roundedPNR);

        if (xDataTable.get(roundedY, roundedPNR) == null || roundedX < xDataTable.get(roundedY, roundedPNR))
        {
            xDataTable.put(roundedY, roundedPNR, roundedX);
        }

        if (yDataTable.get(roundedX, roundedPNR) == null || roundedY < yDataTable.get(roundedX, roundedPNR))
        {
            yDataTable.put(roundedX, roundedPNR, roundedY);
        }

        if (!minPnrMap.containsKey(roundedPNR) || (isClosetToZero(roundedPNR, roundedX, roundedY)))
        {
            minPnrMap.put(roundedPNR, new DataPair(roundedX, roundedY));
        }
    }

    /**
     * Validate if the internal map value is greater that the parameters.
     *
     * @param roundedPNR the rounded pnr to validate map pair.
     * @param roundedX   the rounded x value.
     * @param roundedY   the rounded y value.
     * @return true if the stored value is greater that the input values;
     */
    static boolean isClosetToZero(Double roundedPNR, Double roundedX, Double roundedY)
    {
        DataPair pair = minPnrMap.get(roundedPNR);
        if (pair.getX() + pair.getY() > roundedX + roundedY)
        {
            return true;
        }
        return false;
    }
}

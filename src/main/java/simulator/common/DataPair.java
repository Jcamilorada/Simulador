package simulator.common;

import java.io.Serializable;

/**
 * @author Juan Camilo Rada
 *
 * DataPair used to store pair of double.
 */
public class DataPair implements Serializable
{
    private final double x;
    private final double y;

    public DataPair(final double x, final double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}

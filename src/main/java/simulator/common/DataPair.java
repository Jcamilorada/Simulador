package simulator.common;

import java.io.Serializable;

public class DataPair implements Serializable
{
    private double x;
    private double y;

    public DataPair(double x, double y)
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

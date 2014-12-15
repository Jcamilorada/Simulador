package simulator.common.graphic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Juan Camilo Rada
 *
 * Point Table information containing surface model information.
 */
public final class PointsTable
{
    private final Table<Double, Double, Point> pointsTable;

    public PointsTable()
    {
        pointsTable = HashBasedTable.create();
    }

    public Point get(final double x, final double y)
    {
        return pointsTable.get(y, x);
    }

    public void put(final double x, final double y, final Point point)
    {
        pointsTable.put(y, x, point);
    }

    public List<Point> getPoints()
    {
        List<Point> pointList = new ArrayList<>(pointsTable.values());
        Collections.sort(pointList);

        return pointList;
    }

    public int size()
    {
        return pointsTable.values().size();
    }
}

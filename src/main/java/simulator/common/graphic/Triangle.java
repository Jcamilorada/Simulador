package simulator.common.graphic;

import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Triangle
{
    @Getter(AccessLevel.PUBLIC)
    private final Point vertex1;
    @Getter(AccessLevel.PUBLIC)
    private final Point vertex2;
    @Getter(AccessLevel.PUBLIC)
    private final Point vertex3;

    public Triangle(final Point vertex1, final Point vertex2, final Point vertex3)
    {
        this.vertex1 =
            Preconditions.checkNotNull(vertex1, "vertex1 cannot be null");
        this.vertex2 =
            Preconditions.checkNotNull(vertex2, "vertex2 cannot be null");
        this.vertex3 =
            Preconditions.checkNotNull(vertex3, "vertex3 cannot be null");
    }

    private Map<Long, Point> getVertixMap()
    {
        Map<Long, Point> pointMap  = new HashMap<Long, Point>(3);
        pointMap.put(vertex1.getIndex(), vertex1);
        pointMap.put(vertex2.getIndex(), vertex2);
        pointMap.put(vertex3.getIndex(), vertex3);

        return pointMap;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (o instanceof Triangle)
        {
            Triangle triangle = (Triangle)o;
            Map<Long, Point> poinMap = this.getVertixMap();

            return poinMap.containsKey(vertex1.getIndex()) &&
                poinMap.containsKey(vertex2.getIndex()) &&
                poinMap.containsKey(vertex3.getIndex());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(vertex1, vertex2, vertex3);
    }
}

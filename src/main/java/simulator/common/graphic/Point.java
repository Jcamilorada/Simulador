package simulator.common.graphic;

import com.google.common.primitives.Longs;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public final class Point implements Comparable<Point>
{
    @Getter(AccessLevel.PUBLIC)
    private final double x;
    @Getter(AccessLevel.PUBLIC)
    private final double y;
    @Getter(AccessLevel.PUBLIC)
    private final double z;
    @Getter(AccessLevel.PUBLIC)
    private final long index;

    public Point(final double x, final double y, final double z, final long index)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }

    public int compareTo(Point point)
    {
        return Longs.compare(this.index, point.index);
    }
}

package simulator.common.graphic;

import com.google.common.primitives.Longs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author Juan Camilo Rada
 *
 * Point representation with the x,y,z coordinates and the color value.
 */
@EqualsAndHashCode
@AllArgsConstructor
public final class Point implements Comparable<Point>
{
    @Getter(AccessLevel.PUBLIC)
    private final Double x;
    @Getter(AccessLevel.PUBLIC)
    private final Double y;
    @Getter(AccessLevel.PUBLIC)
    private final Double z;
    @Getter(AccessLevel.PUBLIC)
    private final long index;
    @Getter(AccessLevel.PUBLIC)
    private final Color color;

    public int compareTo(Point point)
    {
        return Longs.compare(this.index, point.index);
    }
}

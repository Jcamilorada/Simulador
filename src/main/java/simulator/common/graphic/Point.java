package simulator.common.graphic;

import com.google.common.primitives.Longs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.MathContext;

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

    public int compareTo(Point point)
    {
        return Longs.compare(this.index, point.index);
    }
}

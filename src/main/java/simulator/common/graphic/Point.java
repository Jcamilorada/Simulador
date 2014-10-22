package simulator.common.graphic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public final class Point
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
}

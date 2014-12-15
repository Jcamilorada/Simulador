package simulator.common.graphic;

import lombok.Data;
import simulator.common.util.ColorUtils;

/**
 * @author Juan Camilo Rada
 *
 * Color class in the hsb representation. see http://en.wikipedia.org/wiki/HSB.
 */
@Data
public class Color
{
    private double h;
    private double s;
    private double b;
    private int value;

    public Color(final double h, final double s, final double b)
    {
        this.h = h;
        this.s = s;
        this.b = b;

        value = ColorUtils.HSBtoRGB(h, s, b);
    }
}

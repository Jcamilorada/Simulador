package simulator.common.graphic;

import lombok.Data;
import simulator.common.util.ColorUtils;

@Data
@SuppressWarnings("PMD.UnusedPrivateField")
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

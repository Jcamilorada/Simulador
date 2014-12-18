package simulator.common.graphic;

/**
 * @author Juan Camilo Rada
 *
 * Color util to perform color operations.
 */
public class ColorUtils
{
    private static String RGB_FORMAT = "#%02x%02x%02x";

    private ColorUtils()
    {
    }

    public static String rgbToHex(final int r, final int g, final int b)
    {
        return String.format(RGB_FORMAT, r, g, b);
    }

    public static int HSBtoRGB(final double hue, final double saturation, final double brightness)
    {
        int r = 0, g = 0, b = 0;
        if (saturation == 0)
        {
            r = g = b = (int) (brightness * 255.0f + 0.5f);
        } else
        {
            double h = (hue - (float) Math.floor(hue)) * 6.0f;
            double f = h - (float) java.lang.Math.floor(h);
            double p = brightness * (1.0f - saturation);
            double q = brightness * (1.0f - saturation * f);
            double t = brightness * (1.0f - saturation * (1.0f - f));
            switch ((int) h)
            {
                case 0:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (t * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 1:
                    r = (int) (q * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 2:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (t * 255.0f + 0.5f);
                    break;
                case 3:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (q * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 4:
                    r = (int) (t * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 5:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (q * 255.0f + 0.5f);
                    break;
                default:
                    throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + brightness);
            }
        }

        r = r * 256 * 256;
        g = g * 256;

        return r + g + b;
    }
}

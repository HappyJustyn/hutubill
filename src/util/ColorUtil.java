package util;

import java.awt.*;

/**
 * 颜色工具类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 0:26
 */
public class ColorUtil {
    public static final Color BLUE = Color.decode("#3399FF");
    public static final Color GRAY = Color.decode("#999999");
    public static final Color BACKGROUND = Color.decode("#eeeeee");
    public static final Color WARNING = Color.decode("#FF3333");

    public static Color getByPercent(int percent) {
        if (percent > 100) {
            percent = 100;
        }
        int r = 51;
        int g = 255;
        int b = 51;
        float rate = (float) percent / 100;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        return new Color(r, g, b);
    }
}

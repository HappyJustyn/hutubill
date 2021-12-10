package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 工具类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/8 19:55
 */
public class GuiUtil {
    private static final String IMAGE_FOLDER = "C:\\Users\\Justyn\\IdeaProjects\\images\\hutubill";

    /**
     * 给按钮添加图片
     *
     * @param button   按钮
     * @param fileName 图片名
     * @param tip      提示信息
     * @author Justyn
     * @date 2021/12/8 19:56
     */
    public static void setImageIcon(JButton button, String fileName, String tip) {
        ImageIcon icon = new ImageIcon(new File(IMAGE_FOLDER, fileName).getAbsolutePath(), tip);
        button.setIcon(icon);
        button.setPreferredSize(new Dimension(61, 81));
        button.setToolTipText(tip);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setText(tip);
    }

    /**
     * 设置组件前景色
     *
     * @author Justyn
     * @date 2021/12/8 23:51
     */
    public static void setColor(Color color, JComponent... components) {
        for (JComponent c : components) {
            c.setForeground(color);
        }
    }

    /**
     * 测试面板用
     *
     * @param p 要显示的面板
     * @author Justyn
     * @date 2021/12/9 1:49
     */
    public static void showPanel(JPanel p, double stretchRate) {
        GuiUtil.useLookAndFeel();
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        CenterPanel panel = new CenterPanel(stretchRate);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.show(p);
    }

    public static void showPanel(JPanel p) {
        showPanel(p, 0.85);
    }

    public static boolean checkNumber(JTextField textField, String input) {
        if (!checkEmpty(textField, input)) {
            return false;
        }
        String text = textField.getText().trim();
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input + "需要是整数");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkZero(JTextField textField, String input) {
        if (!checkEmpty(textField, input)) {
            return false;
        }
        String text = textField.getText().trim();
        if (0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, input + "不能为零");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * 检测文本域的值是否为空
     *
     * @param textField 文本域
     * @param input     文本域名
     * @return true 不为空
     * @author Justyn
     * @date 2021/12/10 16:38
     */
    public static boolean checkEmpty(JTextField textField, String input) {
        String text = textField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(null, input + "不能为空");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    public static int getInt(JTextField textField) {
        return Integer.parseInt(textField.getText());
    }


    /**
     * @Description 更换主题
     * @Author Justyn
     * @Date 2021/12/8 19:36
     */
    public static void useLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

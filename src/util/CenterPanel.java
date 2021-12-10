package util;

import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 内容居中的面板-用来放其他面板
 *
 * @author Justyn
 */
public class CenterPanel extends JPanel {
    /**
     * 拉伸比例
     */
    private double rate;
    /**
     * 显示的面板
     */
    private JComponent component;
    /**
     * 是否拉伸
     */
    private boolean stretch;

    public CenterPanel(double rate, boolean stretch) {
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }


    @Override
    public void repaint() {
        if (null != component) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = component.getSize();
            if (stretch) {
                component.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            } else {
                component.setSize(componentSize);
            }
            component.setLocation(containerSize.width / 2 - component.getWidth() / 2, containerSize.height / 2 - component.getHeight() / 2);
        }
        // 父类repaint方法内有需要进行的逻辑处理
        super.repaint();
    }

    /**
     * 根据拉伸比例显示组件
     *
     * @param p 要显示的组件
     * @author Justyn
     * @date 2021/12/8 23:47
     */
    public void show(JComponent p) {
        this.component = p;
        // Gets all the components in this container.
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
        // 各个面板更新数据
        if (p instanceof WorkingPanel) {
            ((WorkingPanel) p).updateData();
        }
        // 调用repaint方法进行面板内容更新
        this.updateUI();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);

        CenterPanel centerPanel = new CenterPanel(0.85, true);
        f.setContentPane(centerPanel);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton button = new JButton("按钮");
        centerPanel.show(button);
    }

}

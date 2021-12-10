package gui.panel;

import javax.swing.*;

/**
 * 抽象其他panel的共同方法
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 18:42
 */
public abstract class WorkingPanel extends JPanel {
    /**
     * 更新panel数据
     */
    public abstract void updateData();

    /**
     * 给panel添加监听器
     */
    public abstract void addListener();
}

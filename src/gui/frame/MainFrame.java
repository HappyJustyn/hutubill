package gui.frame;

import gui.panel.MainPanel;
import util.GuiUtil;

import javax.swing.*;

/**
 * 主体窗口
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:19
 */
public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame() {
        setSize(500, 450);
        setTitle("一本糊涂账");
        setContentPane(MainPanel.instance);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}

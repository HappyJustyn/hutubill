package gui.panel;

import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

/**
 * 备份面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:09
 */
public class BackupPanel extends JPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static BackupPanel instance = new BackupPanel();

    JButton bBackup = new JButton("备份");

    public BackupPanel() {
        GuiUtil.setColor(ColorUtil.BLUE, bBackup);
        add(bBackup);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }
}

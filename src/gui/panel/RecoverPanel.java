package gui.panel;

import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

/**
 * 恢复面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:12
 */
public class RecoverPanel extends JPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("恢复");

    public RecoverPanel() {
        GuiUtil.setColor(ColorUtil.BLUE, bRecover);
        add(bRecover);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }
}

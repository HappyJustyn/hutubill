package gui.listener;

import gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 工具面板监听器，实现点击按钮切换显示的界面
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 2:24
 */
public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.reportButton) {
            p.workingPanel.show(ReportPanel.instance);
        }
        if (b == p.categoryButton) {
            p.workingPanel.show(CategoryPanel.instance);
        }
        if (b == p.spendButton) {
            p.workingPanel.show(SpendPanel.instance);
        }
        if (b == p.recordButton) {
            p.workingPanel.show(RecordPanel.instance);
        }
        if (b == p.configButton) {
            p.workingPanel.show(ConfigPanel.instance);
        }
        if (b == p.backupButton) {
            p.workingPanel.show(BackupPanel.instance);
        }
        if (b == p.recoverButton) {
            p.workingPanel.show(RecoverPanel.instance);
        }
    }
}

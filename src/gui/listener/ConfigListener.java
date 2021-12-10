package gui.listener;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GuiUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * ConfigListener
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 16:33
 */
public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        if (!GuiUtil.checkNumber(p.tfBudget, "本月预算")) {
            return;
        }
        String mysqlPath = p.tfMysqlPath.getText();
        if (!mysqlPath.isEmpty()) {
            File commandFile = new File(mysqlPath, "bin/mysql.exe");
            if (!commandFile.exists()) {
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }
        ConfigService cs = new ConfigService();
        cs.update(ConfigService.BUDGET_KEY, p.tfBudget.getText());
        cs.update(ConfigService.MYSQL_PATH_KEY, mysqlPath);

        JOptionPane.showMessageDialog(p, "设置修改成功");
    }
}

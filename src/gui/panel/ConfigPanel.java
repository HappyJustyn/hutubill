package gui.panel;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 设置面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 17:59
 */
public class ConfigPanel extends WorkingPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算（￥）");
    public JTextField tfBudget = new JTextField("0");
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");
    public JButton bSubmit = new JButton("更新");

    public ConfigPanel() {
        GuiUtil.setColor(ColorUtil.GRAY, lBudget, lMysql);
        GuiUtil.setColor(ColorUtil.BLUE, bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        pSubmit.add(bSubmit);

        setLayout(new BorderLayout());
        add(pInput, BorderLayout.NORTH);
        add(pSubmit, BorderLayout.CENTER);

        addListener();
    }

    @Override
    public void updateData() {
        String budget = new ConfigService().get(ConfigService.BUDGET_KEY);
        String mysqlPath = new ConfigService().get(ConfigService.MYSQL_PATH_KEY);
        tfBudget.setText(budget);
        tfMysqlPath.setText(mysqlPath);
        tfBudget.grabFocus();
    }

    @Override
    public void addListener() {
        ConfigListener l = new ConfigListener();
        bSubmit.addActionListener(l);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }

}

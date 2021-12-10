package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 主窗体的ContentPanel
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 1:30
 */
public class MainPanel extends JPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    /**
     * 单例MainPanel
     */
    public static MainPanel instance = new MainPanel();
    public JToolBar toolBar = new JToolBar();
    public JButton spendButton = new JButton();
    public JButton recordButton = new JButton();
    public JButton categoryButton = new JButton();
    public JButton reportButton = new JButton();
    public JButton configButton = new JButton();
    public JButton backupButton = new JButton();
    public JButton recoverButton = new JButton();
    public CenterPanel workingPanel;

    private MainPanel() {
        GuiUtil.setImageIcon(spendButton, "home.png", "消费一览");
        GuiUtil.setImageIcon(recordButton, "record.png", "记一笔");
        GuiUtil.setImageIcon(categoryButton, "category2.png", "消费分类");
        GuiUtil.setImageIcon(reportButton, "report.png", "月消费报表");
        GuiUtil.setImageIcon(configButton, "config.png", "设置");
        GuiUtil.setImageIcon(backupButton, "backup.png", "备份");
        GuiUtil.setImageIcon(recoverButton, "restore.png", "恢复");
        toolBar.add(spendButton);
        toolBar.add(recordButton);
        toolBar.add(categoryButton);
        toolBar.add(reportButton);
        toolBar.add(configButton);
        toolBar.add(backupButton);
        toolBar.add(recoverButton);
        workingPanel = new CenterPanel(0.8);
        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }

    private void addListener() {
        ToolBarListener listener = new ToolBarListener();
        spendButton.addActionListener(listener);
        recordButton.addActionListener(listener);
        categoryButton.addActionListener(listener);
        reportButton.addActionListener(listener);
        configButton.addActionListener(listener);
        backupButton.addActionListener(listener);
        recoverButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance, 1);
    }

}

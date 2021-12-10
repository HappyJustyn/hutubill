package gui.panel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 消费面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 2:34
 */
public class SpendPanel extends WorkingPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    /**
     * 单例SpendPanel
     */
    public static SpendPanel instance = new SpendPanel();

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月余额");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel("￥2300");
    public JLabel vTodaySpend = new JLabel("￥25");
    public JLabel vAvgSpendPerDay = new JLabel("￥120");
    public JLabel vMonthAvailable = new JLabel("￥2048");
    public JLabel vDayAvgAvailable = new JLabel("￥389");
    public JLabel vMonthLeftDay = new JLabel("15天");

    CircleProgressBar bar;

    public SpendPanel() {
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.BLUE);
        GuiUtil.setColor(ColorUtil.GRAY, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GuiUtil.setColor(ColorUtil.BLUE, vMonthSpend, vTodaySpend);
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        setLayout(new BorderLayout());
        add(center(), BorderLayout.CENTER);
        add(south(), BorderLayout.SOUTH);
    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(), BorderLayout.CENTER);
        return p;
    }

    private JPanel center2() {
        return bar;
    }

    private JPanel west() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(lMonthSpend);
        panel.add(vMonthSpend);
        panel.add(lTodaySpend);
        panel.add(vTodaySpend);
        return panel;
    }

    private JPanel south() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4));
        panel.add(lAvgSpendPerDay);
        panel.add(lMonthLeft);
        panel.add(lDayAvgAvailable);
        panel.add(lMonthLeftDay);
        panel.add(vAvgSpendPerDay);
        panel.add(vMonthAvailable);
        panel.add(vDayAvgAvailable);
        panel.add(vMonthLeftDay);
        return panel;
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }

    @Override
    public void updateData() {
        SpendPage spend = new SpendService().getSpendPage();
        vMonthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);

        bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.WARNING);
            vMonthSpend.setForeground(ColorUtil.WARNING);
            vTodaySpend.setForeground(ColorUtil.WARNING);
        } else {
            vMonthAvailable.setForeground(ColorUtil.GRAY);
            vMonthSpend.setForeground(ColorUtil.GRAY);
            vTodaySpend.setForeground(ColorUtil.GRAY);
        }
        bar.setForeground(ColorUtil.getByPercent(spend.usagePercentage));
    }

    @Override
    public void addListener() {

    }
}

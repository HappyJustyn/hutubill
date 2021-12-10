package gui.panel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 报表面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 17:54
 */
public class ReportPanel extends WorkingPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        setLayout(new BorderLayout());
        Image i = ChartUtil.getImage(400, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        add(l);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }

    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecord();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}

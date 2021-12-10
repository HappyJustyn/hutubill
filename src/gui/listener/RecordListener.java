package gui.listener;

import entity.Category;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GuiUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * RecordListener
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 19:40
 */
public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel p = RecordPanel.instance;
        if (0 == p.cbModel.cs.size()) {
            JOptionPane.showMessageDialog(p, "暂无消费分类，请先添加消费分类");
            return;
        }
        if (!GuiUtil.checkZero(p.tfSpend, "花费金额")) {
            return;
        }
        int spend = Integer.parseInt(p.tfSpend.getText());
        Category c = p.getSelectedCategory();
        String comment = p.tfComment.getText();
        Date d = p.datePicker.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "添加成功");
        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}

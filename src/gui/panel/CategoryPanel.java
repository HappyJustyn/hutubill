package gui.panel;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 分类信息面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 17:37
 */
public class CategoryPanel extends WorkingPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static CategoryPanel instance = new CategoryPanel();
    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    public CategoryPanel() {
        GuiUtil.setColor(ColorUtil.BLUE, bAdd, bEdit, bDelete);
        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    @Override
    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }

    public Category getSelectedCategory() {
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }

    @Override
    public void updateData() {
        ctm.cs = new CategoryService().list();
        t.updateUI();
        // 默认选取第一行
        t.getSelectionModel().setSelectionInterval(0, 0);
        if (0 == ctm.cs.size()) {
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }

}

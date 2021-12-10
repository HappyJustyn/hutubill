package gui.listener;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CategoryListener
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 17:46
 */
public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bAdd) {
            String name = JOptionPane.showInputDialog(p, "请输入分类名称");
            // showInputDialog取消返回null
            if (null == name) {
                return;
            }
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }
        if (b == p.bEdit) {
            Category c = p.getSelectedCategory();
            int id = c.getId();
            String name = JOptionPane.showInputDialog(p, "修改分类名称", c.getName());
            if (null == name) {
                return;
            }
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().update(id, name);
        }
        if (b == p.bDelete) {
            Category c = p.getSelectedCategory();
            if (0 != c.getRecordNumber()) {
                JOptionPane.showMessageDialog(p, "该分类下有消费记录存在，不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(p, "确定删除该分类？")) {
                new CategoryService().delete(c.getId());
            }
        }
        p.updateData();
    }
}

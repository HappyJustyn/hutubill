package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 下拉框数据模型
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 15:39
 */
public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    //    public List<String> cs = new ArrayList<>();
    public List<Category> cs = new CategoryService().list();

    /**
     * 选中值
     */
    public Category c;

    public CategoryComboBoxModel() {
        if (!cs.isEmpty()) {
            c = cs.get(0);
        }
    }

//    public CategoryComboBoxModel() {
//        cs.add("餐饮");
//        cs.add("交通");
//        cs.add("住宿");
//        cs.add("话费");
//        c = cs.get(0);
//    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}

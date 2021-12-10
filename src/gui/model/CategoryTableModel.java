package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * 分类面板数据模型
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 17:21
 */
public class CategoryTableModel implements TableModel {

    String[] columns = {"分类名称", "消费次数"};
    //    List<String> cs = new ArrayList<>();
    public List<Category> cs = new CategoryService().list();

//    public CategoryTableModel() {
//        cs.add("餐饮");
//        cs.add("交通");
//        cs.add("住宿");
//        cs.add("话费");
//    }

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columns[columnIndex].getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category c = cs.get(rowIndex);
        if (columnIndex == 0) {
            return c.getName();
        }
        if (columnIndex == 1) {
            return c.getRecordNumber();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

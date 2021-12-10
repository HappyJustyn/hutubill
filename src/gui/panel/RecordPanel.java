package gui.panel;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GuiUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * 记一笔面板
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 15:36
 */
public class RecordPanel extends WorkingPanel {
//    static {
//        GuiUtil.useLookAndFeel();
//    }

    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费（￥）");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datePicker = new JXDatePicker(new Date());
    public JButton bSubmit = new JButton("记一笔");

    public RecordPanel() {
        GuiUtil.setColor(ColorUtil.GRAY, lSpend, lCategory, lComment, lDate);
        GuiUtil.setColor(ColorUtil.BLUE, bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 2, gap, gap));
        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datePicker);
        pSubmit.add(bSubmit);

        setLayout(new BorderLayout());
        add(pInput, BorderLayout.NORTH);
        add(pSubmit, BorderLayout.CENTER);

        addListener();
    }

    public Category getSelectedCategory() {
        return (Category) cbCategory.getSelectedItem();
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(instance);
    }

    @Override
    public void updateData() {
        cbModel.cs = new CategoryService().list();
        // 更新数据
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    private void resetInput() {
        tfSpend.setText("0");
        tfComment.setText("");
        if (0 != cbModel.cs.size()) {
            cbCategory.setSelectedIndex(0);
        }
        datePicker.setDate(new Date());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        bSubmit.addActionListener(listener);
    }
}

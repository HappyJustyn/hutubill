package startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GuiUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 启动类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 1:36
 */
public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        // 这里设置主题，其他panel中就不用设置了
        GuiUtil.useLookAndFeel();
        // https://blog.csdn.net/XiaoYunKuaiFei/article/details/108529344
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}

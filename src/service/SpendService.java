package service;

import dao.RecordDao;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

import java.util.List;

/**
 * SpendService
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 23:10
 */
public class SpendService {

    public SpendPage getSpendPage() {
        RecordDao dao = new RecordDao();
        // 本月数据
        List<Record> thisMonthRecords = dao.listThisMonth();
        // 今日数据
        List<Record> todayRecords = dao.listToday();
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        // 本月消费
        int monthSpend = 0;
        // 今日消费
        int todaySpend = 0;
        // 日均消费
        int avgSpendPerDay = 0;
        // 本月剩余
        int monthAvailable = 0;
        // 日均可用
        int dayAvgAvailable = 0;
        // 本月剩余天数
        int monthLeftDay = 0;
        // 本月使用比例
        int usagePercentage = 0;

        // 本月预算
        int monthBudget = new ConfigService().getIntBudget();

        for (Record r : thisMonthRecords) {
            monthSpend += r.getSpend();
        }
        for (Record r : todayRecords) {
            todaySpend += r.getSpend();
        }
//        avgSpendPerDay = monthSpend / thisMonthTotalDay;
        avgSpendPerDay = monthSpend / DateUtil.thisMonthPastDay();
        monthAvailable = monthBudget - monthSpend;
        monthLeftDay = DateUtil.thisMonthLeftDay();
        dayAvgAvailable = monthAvailable / monthLeftDay;
        usagePercentage = monthSpend * 100 / monthBudget;
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay, usagePercentage);
    }
}

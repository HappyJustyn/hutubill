package service;

import dao.RecordDao;
import entity.Record;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * ReportService
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/11 0:13
 */
public class ReportService {
    /**
     * 获取某天的消费金额
     *
     * @param d            当天日期
     * @param monthRawData 月数据集合
     * @return int
     */
    public int getDaySpend(Date d, List<Record> monthRawData) {
        int daySpend = 0;
        for (Record r : monthRawData) {
            if (r.getDate().equals(d)) {
                daySpend += r.getSpend();
            }
        }
        return daySpend;
    }

    /**
     * 获取这个月每天的消费记录集合（一天的消费放到一个Record里）
     */
    public List<Record> listThisMonthRecord() {
        RecordDao dao = new RecordDao();
        List<Record> monthRawData = dao.listThisMonth();
        List<Record> result = new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth = c.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
            Record record = new Record();
            record.setSpend(daySpend);
            result.add(record);
        }
        return result;
    }
}

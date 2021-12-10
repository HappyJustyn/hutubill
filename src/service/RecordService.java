package service;

import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Date;

/**
 * RecordService
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 19:29
 */
public class RecordService {
    RecordDao recordDao = new RecordDao();

    public void add(int spend, Category c, String comment, Date date) {
        Record r = new Record();
        r.setSpend(spend);
        r.setCid(c.getId());
        r.setComment(comment);
        r.setDate(date);
        recordDao.add(r);
    }
}

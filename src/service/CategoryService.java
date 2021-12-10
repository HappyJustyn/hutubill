package service;

import dao.CategoryDao;
import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Comparator;
import java.util.List;

/**
 * CategoryService
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 17:14
 */
public class CategoryService {

    CategoryDao categoryDao = new CategoryDao();
    RecordDao recordDao = new RecordDao();

    public List<Category> list() {
        List<Category> cs = categoryDao.list();
        for (Category c : cs) {
            List<Record> rs = recordDao.list(c.getId());
            c.setRecordNumber(rs.size());
        }
        cs.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getRecordNumber() - o2.getRecordNumber();
            }
        });
        return cs;
    }

    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    public void update(int id, String name) {
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        categoryDao.update(c);
    }

    public void delete(int id) {
        categoryDao.delete(id);
    }
}

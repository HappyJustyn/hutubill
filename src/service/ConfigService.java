package service;

import dao.ConfigDao;
import entity.Config;

/**
 * ConfigService
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 16:14
 */
public class ConfigService {

    public static final String MYSQL_PATH_KEY = "mysqlPath";
    public static final String BUDGET_KEY = "budget";
    static final String DEFAULT_BUDGET = "500";

    static ConfigDao dao = new ConfigDao();

    static {
        // 如果数据库为空，就进行初始化操作
        init();
    }

    private static void init() {
        init(BUDGET_KEY, DEFAULT_BUDGET);
        init(MYSQL_PATH_KEY, "");
    }

    private static void init(String key, String value) {
        Config config = dao.getByKey(key);
        if (null == config) {
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }
    }

    public String get(String key) {
        return dao.getByKey(key).getValue();
    }

    public void update(String key, String value) {
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(BUDGET_KEY));
    }
}

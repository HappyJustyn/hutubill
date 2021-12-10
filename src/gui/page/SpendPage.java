package gui.page;

/**
 * 消费一览的业务类
 * 对数据库拿到的数据进行加工，封装成一个业务类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/10 22:10
 */
public class SpendPage {
    /**
     * 本月消费
     */
    public String monthSpend;
    /**
     * 今日消费
     */
    public String todaySpend;
    /**
     * 日均消费
     */
    public String avgSpendPerDay;
    /**
     * 本月剩余
     */
    public String monthAvailable;
    /**
     * 日均可用
     */
    public String dayAvgAvailable;
    /**
     * 距离月末
     */
    public String monthLeftDay;
    /**
     * 使用比例
     */
    public int usagePercentage;
    /**
     * 是否超支
     */
    public boolean isOverSpend;


    public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
                     int monthLeftDay, int usagePercentage) {
        this.monthSpend = "￥" + monthSpend;
        this.todaySpend = "￥" + todaySpend;
        this.avgSpendPerDay = "￥" + avgSpendPerDay;
        if (monthAvailable < 0) {
            isOverSpend = true;
        }
        if (!isOverSpend) {
            this.monthAvailable = "￥" + monthAvailable;
            this.dayAvgAvailable = "￥" + dayAvgAvailable;
        } else {
            this.monthAvailable = "超支" + (-monthAvailable);
            this.dayAvgAvailable = "￥0";
        }
        this.monthLeftDay = monthLeftDay + "天";
        this.usagePercentage = usagePercentage;
    }
}

package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 消费信息
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:42
 */
public class Record implements Serializable {
    private int id;
    private int spend;
    private int cid;
    private String comment;
    private Date date;

    public Record() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

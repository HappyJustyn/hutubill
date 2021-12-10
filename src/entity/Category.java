package entity;

import java.io.Serializable;

/**
 * 消费分类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:40
 */
public class Category implements Serializable {
    private int id;
    private String name;
    /**
     * 当前分类的消费记录数量
     */
    private int recordNumber;

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}

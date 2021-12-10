package entity;

import java.io.Serializable;

/**
 * 配置
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:27
 */
public class Config implements Serializable {
    private int id;
    private String key;
    private String value;

    public Config() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

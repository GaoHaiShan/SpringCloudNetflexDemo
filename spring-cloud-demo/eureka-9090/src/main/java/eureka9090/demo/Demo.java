package eureka9090.demo;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    private List<String> pics = new LinkedList<>();

    private Integer count = 0;

    public Demo() {
    }

    public Demo(List<String> pics, Integer count) {
        this.pics = pics;
        this.count = count;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

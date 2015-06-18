package stream.api.code.kata;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Customer {

    private String name;
    private Integer age;
    private Integer money;
    private List<Item> wantToBuy;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @XmlAttribute
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @XmlElement(name = "item")
    public List<Item> getWantToBuy() {
        return wantToBuy;
    }

    public void setWantToBuy(List<Item> wantToBuy) {
        this.wantToBuy = wantToBuy;
    }
}

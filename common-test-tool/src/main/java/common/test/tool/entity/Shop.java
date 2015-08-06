package common.test.tool.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Shop {

    private String name;
    private List<Item> itemList;

    @XmlAttribute
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "item")
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}

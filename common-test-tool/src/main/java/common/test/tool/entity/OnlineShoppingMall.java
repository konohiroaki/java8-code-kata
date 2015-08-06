package common.test.tool.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mall")
public class OnlineShoppingMall {

    private List<Shop> shopList;
    private List<Customer> customerList;


    @XmlElementWrapper(name="shops")
    @XmlElement(name="shop")
    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @XmlElementWrapper(name="customers")
    @XmlElement(name="customer")
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

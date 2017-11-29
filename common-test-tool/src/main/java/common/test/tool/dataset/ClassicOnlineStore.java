package common.test.tool.dataset;

import common.test.tool.entity.OnlineShoppingMall;

import java.io.File;

import javax.xml.bind.JAXB;

public class ClassicOnlineStore {

    protected final OnlineShoppingMall mall =
        JAXB.unmarshal(getClass().getClassLoader().getResource("data.xml"), OnlineShoppingMall.class);
}

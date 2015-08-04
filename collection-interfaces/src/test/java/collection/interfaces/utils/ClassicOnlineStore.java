package collection.interfaces.utils;

import java.io.File;

import javax.xml.bind.JAXB;

import collection.interfaces.entity.OnlineShoppingMall;

public class ClassicOnlineStore {

    protected final OnlineShoppingMall mall =
        JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
}

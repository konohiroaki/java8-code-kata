package stream.api.utils;

import java.io.File;

import javax.xml.bind.JAXB;

import stream.api.entity.OnlineShoppingMall;

public class ClassicOnlineStore {

    protected final OnlineShoppingMall mall =
        JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
}

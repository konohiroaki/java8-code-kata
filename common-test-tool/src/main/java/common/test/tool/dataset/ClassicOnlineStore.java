package common.test.tool.dataset;

import common.test.tool.entity.OnlineShoppingMall;

import java.io.File;

import javax.xml.bind.JAXB;

public class ClassicOnlineStore {

    protected final OnlineShoppingMall mall =
        JAXB.unmarshal(new File("../common-test-tool/src/test/resources/data.xml"), OnlineShoppingMall.class);
}

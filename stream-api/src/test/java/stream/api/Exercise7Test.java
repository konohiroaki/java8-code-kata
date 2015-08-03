package stream.api;

import org.junit.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import stream.api.entity.Customer;
import stream.api.entity.Shop;
import stream.api.utils.ClassicOnlineStore;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise7Test extends ClassicOnlineStore {

    @Test
    public void averageAge() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create {@link java.util.stream.IntStream} with customer ages by using {@link java.util.stream.Stream#mapToInt}
         * Then calculate the average of ages by using {@link java.util.stream.IntStream#average}
         */
        IntStream ageStream = null;
        OptionalDouble average = null;

        assertThat(average.getAsDouble(), is(28.7));
    }

    @Test
    public void howMuchToBuyAllItems() {
        List<Shop> shopList = this.mall.getShopList();

        /**
         * Create {@link java.util.stream.LongStream} with all items' prices using {@link java.util.stream.Stream#mapToLong}
         * Then calculate the sum of prices using {@link java.util.stream.LongStream#sum}
         */
        LongStream priceStream = null;
        long priceSum = 0;

        assertThat(priceSum, is(60930L));
    }
}

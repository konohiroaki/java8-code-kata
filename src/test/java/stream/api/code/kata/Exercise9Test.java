package stream.api.code.kata;

import org.junit.Test;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import stream.api.code.kata.entity.Customer;
import stream.api.code.kata.utils.ClassicOnlineStore;
import stream.api.code.kata.utils.CollectorImpl;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise9Test extends ClassicOnlineStore {

    @Test
    public void simplestStringJoin() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Implement a Collector which can create a string with comma separated names shown in the assertion.
         * You also need to change the wildcard to an actual type you will use for your collector.
         * The collector will be used by serial stream.
         */
        Supplier<?> supplier = null;
        BiConsumer<?, String> accumulator = null;
        BinaryOperator<?> combiner = null;
        Function<?, String> finisher = null;

        Collector<String, ?, String> toCsv =
            new CollectorImpl<>(supplier, accumulator, combiner, finisher, Collections.emptySet());
        String nameAsCsv = customerList.stream().map(Customer::getName).collect(toCsv);
        assertThat(nameAsCsv, is("Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy"));
    }

    @Test
    public void mapKeyedByItems() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a map with keys as item and values as set of customers who are wanting to buy that item.
         * The collector will be used by parallel stream.
         */
        Supplier<Map<String, Set<String>>> supplier = null;
        BiConsumer<Map<String, Set<String>>, Customer> accumulator = null;
        BinaryOperator<Map<String, Set<String>>> combiner = null;
        Function<Map<String, Set<String>>, Map<String, Set<String>>> finisher = null;

        Collector<Customer, ?, Map<String, Set<String>>> toItemAsKey =
            new CollectorImpl<>(supplier, accumulator, combiner, finisher, EnumSet.of(
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.IDENTITY_FINISH));
        Map<String, Set<String>> itemMap = customerList.stream().parallel().collect(toItemAsKey);
        assertThat(itemMap.get("plane"), containsInAnyOrder("Chris"));
        assertThat(itemMap.get("onion"), containsInAnyOrder("Patrick", "Amy"));
        assertThat(itemMap.get("ice cream"), containsInAnyOrder("Patrick", "Steven"));
        assertThat(itemMap.get("earphone"), containsInAnyOrder("Steven"));
        assertThat(itemMap.get("plate"), containsInAnyOrder("Joe", "Martin"));
        assertThat(itemMap.get("fork"), containsInAnyOrder("Joe", "Martin"));
        assertThat(itemMap.get("cable"), containsInAnyOrder("Diana", "Steven"));
        assertThat(itemMap.get("desk"), containsInAnyOrder("Alice"));
    }
}

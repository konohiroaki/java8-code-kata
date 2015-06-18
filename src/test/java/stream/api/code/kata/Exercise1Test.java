package stream.api.code.kata;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stream.api.code.kata.utils.ClassicOnlineStore;

import static org.junit.Assert.*;
import static stream.api.code.kata.utils.AssertUtil.isLambda;

public class Exercise1Test extends ClassicOnlineStore {

    @Test
    public void findRichCustomers() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a {@link Stream} from customerList only including customer who has more than 10000 money.
         * Use lambda expression for Predicate and {@link Stream#filter} for filtering.
         */
        Predicate<Customer> richCustomerCondition = null;
        Stream<Customer> richCustomerStream = null;

        assertTrue("Solution for Predicate should be lambda expression", isLambda(richCustomerCondition));
        List<Customer> richCustomer = richCustomerStream.collect(Collectors.toList());
        assertThat(richCustomer, Matchers.hasSize(2));
        assertThat(richCustomer, Matchers.hasItems(customerList.get(3), customerList.get(7)));
    }

    @Test
    public void howOldAreTheCustomers() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a {@link Stream} from customerList with age values.
         * Use method reference(best) or lambda expression(okay) for Function
         * and {@link Stream#map} for mapping age value to stream.
         */
        Function<Customer, Integer> getAgeFunction = null;
        Stream<Integer> ageStream = null;

        assertTrue(isLambda(getAgeFunction));
        List<Integer> richCustomer = ageStream.collect(Collectors.toList());
        assertThat(richCustomer, Matchers.hasSize(10));
        assertThat(richCustomer, Matchers.hasItems(22, 27, 28, 38, 26, 22, 32, 35, 21, 36));
    }
}

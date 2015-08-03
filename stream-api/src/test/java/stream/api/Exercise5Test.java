package stream.api;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import stream.api.entity.Customer;
import stream.api.utils.ClassicOnlineStore;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise5Test extends ClassicOnlineStore {

    @Test
    public void nameList() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a list of customer names by using {@link java.util.stream.Stream#collect} and {@link java.util.stream.Collectors#toList}
         */
        List<String> nameList = customerList.stream().map(Customer::getName).collect(Collectors.toList());

        assertThat(nameList, contains("Joe", "Steven", "Patrick", "Diana", "Chris", "Kathy", "Alice", "Andrew",
                                      "Martin", "Amy"));
    }

    @Test
    public void ageSet() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a set of customer age by using {@link java.util.stream.Stream#collect} and {@link java.util.stream.Collectors#toSet}
         */
        Set<Integer> ageSet = customerList.stream().map(Customer::getAge).collect(Collectors.toSet());

        assertThat(ageSet, hasSize(9));
        assertThat(ageSet, hasItems(21, 22, 26, 27, 28, 32, 35, 36, 38));
    }

    @Test
    public void nameInCsv() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a csv string of customer names in brackets "[]" by using {@link java.util.stream.Collectors#joining}
         */
        String string = customerList.stream().map(Customer::getName).collect(Collectors.joining(",", "[", "]"));

        assertThat(string, is("[Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy]"));
    }

    @Test
    public void oldestCustomer() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Get the oldest customer by using {@link java.util.stream.Collectors#maxBy}.
         * Don't use any intermediate operations.
         */
        Optional<Customer> oldestCustomer = customerList.stream()
            .collect(Collectors.maxBy((customer1, customer2) -> customer1.getAge() - customer2.getAge()));

        assertThat(oldestCustomer.get(), is(customerList.get(3)));
    }

    @Test
    public void ageDistribution() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Create a map of age as key and number of customers as value
         * using {@link java.util.stream.Collectors#groupingBy} and {@link java.util.stream.Collectors#counting}
         */
        Map<Integer, Long> ageDistribution = customerList.stream()
            .collect(Collectors.groupingBy(Customer::getAge, Collectors.counting()));

        assertThat(ageDistribution.size(), is(9));
        ageDistribution.forEach((k, v) -> {
            if (k.equals(22)) {
                assertThat(v, is(2L));
            } else {
                assertThat(v, is(1L));
            }
        });
    }
}

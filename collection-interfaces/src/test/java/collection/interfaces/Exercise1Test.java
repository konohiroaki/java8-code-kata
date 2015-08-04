package collection.interfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import collection.interfaces.entity.Customer;
import collection.interfaces.utils.ClassicOnlineStore;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Exercise1Test extends ClassicOnlineStore {

    @Test
    public void iterateByForEach() {
        Iterable<Customer> customerIterable = this.mall.getCustomerList();
        List<String> nameList = new ArrayList<>();

        /**
         * Create a {@link Consumer} which represents an operation to add customer's name to {@link nameList} list.
         * Iterate {@link customerIterable} with {@link Iterable#forEach} and use the {@link Consumer}
         * to finish creating the name list.
         */
        Consumer<Object> consumer = null;
        customerIterable.forEach(null);

        assertThat(nameList.toString(), is("[Joe, Steven, Patrick, Diana, Chris, Kathy, Alice, Andrew, Martin, Amy]"));
    }

    @Test
    public void whoHaveNoEInYourName() {
        Collection<String> nameCollection =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Predicate} which predicates whether the input string containing string "e".
         * Remove elements from {@link nameCollection} which
         */
        Predicate<Object> predicate = null;
        nameCollection.removeIf(null);

        assertThat(nameCollection.toString(), is("[Patrick, Chris]"));
    }

    @Test
    public void replaceTheElements() {
        List<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link UnaryOperator} which returns given string wrapped with "()".
         * Replace the elements in {@link nameList} with string wrapped with brackets like shown in the assertion.
         */
        UnaryOperator<Object> unaryOperator = null;
        nameList.replaceAll(null);

        assertThat(nameList.toString(), is("[(Joe), (Steven), (Patrick), (Chris)]"));
    }

    @Test
    public void sortByName() {
        List<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a {@link Comparator} to sort the name list by their name's length in ascending order.
         */
        Comparator<Object> comparator = null;
        nameList.sort(null);

        assertThat(nameList.toString(), is("[Joe, Chris, Steven, Patrick]"));
    }

    @Test
    public void createStream() {
        Collection<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a serial {@link Stream} using {@link Collection#stream}
         */
        Stream<Object> nameStream = null;

        assertThat(nameStream.count(), is(4L));
        assertThat(nameStream.isParallel(), is(false));
    }

    @Test
    public void createParallelStream() {
        Collection<String> nameList =
            new ArrayList<>(Arrays.asList("Joe", "Steven", "Patrick", "Chris"));

        /**
         * Create a serial {@link Stream} using {@link Collection#parallelStream} or {@link Stream#parallel}
         */
        Stream<Object> nameParallelStream = null;

        assertThat(nameParallelStream.count(), is(4L));
        assertThat(nameParallelStream.isParallel(), is(true));
    }
}

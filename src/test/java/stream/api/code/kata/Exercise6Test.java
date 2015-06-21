package stream.api.code.kata;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class Exercise6Test {

    @Test
    public void streamFromValues() {
        /**
         * Create a stream with string values "one" "two" "three" using {@link Stream#of}
         */
        Stream<String> oneTwoThreeStream = Stream.of("one", "two", "three");

        List<String> oneTwoThreeList = oneTwoThreeStream.collect(Collectors.toList());
        assertThat(oneTwoThreeList, contains("one", "two", "three"));
    }

    @Test
    public void numberStream() {
        /**
         * Create a stream only with multiples of 3, starting from 0, size of 10, using {@link Stream#iterate}
         */
        Stream<Integer> numbers = Stream.iterate(0, ele -> ele + 3).limit(10);

        List<Integer> numbersList = numbers.collect(Collectors.toList());
        assertThat(numbersList, contains(0, 3, 6, 9, 12, 15, 18, 21, 24, 27));
    }
}

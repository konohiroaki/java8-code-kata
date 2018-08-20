package stream.api;

import common.test.tool.annotation.Easy;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class Exercise6Test {

    @Easy @Test
    public void streamFromValues() {
        /**
         * Create a stream with string values "a" "b" "c" by using {@link Stream#of}
         */
        Stream<String> abcStream = Stream.of("a", "b", "c");

        List<String> abcList = abcStream.collect(Collectors.toList());
        assertThat(abcList, contains("a", "b", "c"));
    }

    @Easy @Test
    public void numberStream() {
        /**
         * Create a stream only with multiples of 3, starting from 0, size of 10, by using {@link Stream#iterate}
         */
        Stream<Integer> numbers = Stream.iterate(0, o -> o + 3).limit(10);

        List<Integer> numbersList = numbers.collect(Collectors.toList());
        assertThat(numbersList, contains(0, 3, 6, 9, 12, 15, 18, 21, 24, 27));
    }
}

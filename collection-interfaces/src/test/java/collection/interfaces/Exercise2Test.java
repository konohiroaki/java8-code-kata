package collection.interfaces;

import common.test.tool.annotation.Easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class Exercise2Test {

    private final Map<String, Integer> map = new HashMap<String, Integer>() {{
        put("Joe", 22);
        put("Steven", 27);
        put("Patrick", 28);
        put("Chris", 26);
    }};

    @Easy @Test
    public void getDefaultValue() {
        Map<String, Integer> map = new HashMap<>(this.map);

        /**
         * Try to get from key "Alice" using {@link Map#getOrDefault}. If the key doesn't exist, use 30 as default.
         */
        Integer defaultVal = map.getOrDefault(  "Alice", 30);

        assertThat(defaultVal, is(30));
    }

    @Easy @Test
    public void putIfNotExisting() {
        Map<String, Integer> map = new HashMap<>(this.map);

        /**
         * Try to put 2 entry with key as "Alice" value as 32, key as "Joe" and value as 32 using {@link Map#putIfAbsent}.
         */
         map.putIfAbsent("Alice", 32);
         map.putIfAbsent("Joe", 32);

        assertThat(map.get("Alice"), is(32));
        assertThat(map.get("Joe"), is(22));
    }

    @Easy @Test
    public void mergeValues() {
        Map<String, Integer> map = new HashMap<>(this.map);

        /**
         * Merge 2 entry to {@link map} with key="Alice" value=32, key="Joe" value=32 using {@link Map#merge}.
         * If the value already exist for the key, remap with sum value.
         */
        BiFunction<Integer, Integer, Integer> remappingFunction = (value1, value2) -> value1 + value2;
         map.merge("Alice", 32, remappingFunction);
         map.merge("Joe", 32, remappingFunction);
        // map.

        assertThat(map.get("Alice"), is(32));
        assertThat(map.get("Joe"), is(54));
    }

    @Easy @Test
    public void ignoringAbsentKeys() {
        Map<String, Integer> map = new HashMap<>(this.map);

        /**
         * Try to increment the value for keys "Joe", "Steven" and "Alice" using {@link Map#computeIfPresent}.
         */
        BiFunction<String, Integer, Integer> remappingFunction = (s, integer) -> integer+1;
         map.computeIfPresent("Joe", remappingFunction);
         map.computeIfPresent("Steven", remappingFunction);
         map.computeIfPresent("Alice", remappingFunction);

        assertThat(map.get("Joe"), is(23));
        assertThat(map.get("Steven"), is(28));
        assertThat(map, not(hasKey("Alice")));
    }
}

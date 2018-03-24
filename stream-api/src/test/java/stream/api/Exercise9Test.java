package stream.api;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;
import common.test.tool.annotation.Difficult;
import common.test.tool.annotation.Easy;
import common.test.tool.dataset.ClassicOnlineStore;
import common.test.tool.entity.Customer;
import common.test.tool.util.CollectorImpl;

public class Exercise9Test extends ClassicOnlineStore {

    @Easy @Test
    public void simplestStringJoin() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Implement a {@link Collector} which can create a String with comma separated names shown in the assertion.
         * The collector will be used by serial stream.
         */
        Supplier<StringBuilder> supplier = StringBuilder::new;
        BiConsumer<StringBuilder, String> accumulator = (builder,input) -> builder.append(input).append(",");
        BinaryOperator<StringBuilder> combiner = null;
        Function<StringBuilder, String> finisher = builder -> builder.deleteCharAt(builder.length()-1).toString() ;

        Collector<String, ?, String> toCsv =
            new CollectorImpl<>(supplier, accumulator, combiner, finisher, Collections.emptySet());
        String nameAsCsv = customerList.stream().map(Customer::getName).collect(toCsv);
        assertThat(nameAsCsv, is("Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy"));
    }

    @Difficult @Test
    public void mapKeyedByItems() {
        List<Customer> customerList = this.mall.getCustomerList();

        /**
         * Implement a {@link Collector} which can create a {@link Map} with keys as item and
         * values as {@link Set} of customers who are wanting to buy that item.
         * The collector will be used by parallel stream.
         */
        Supplier<Map<String, Set<String>>> supplier = HashMap::new;
        BiFunction<Set<String>, Set<String>, Set<String>> mapper = (set1,set2) -> {set2.addAll(set1); return set2;};
        BiConsumer<Map<String, Set<String>>, Customer> accumulator = (map,customer) -> customer.getWantToBuy().forEach(item -> map.merge(item.getName(), Stream.of(customer.getName()).collect(Collectors.toSet()), mapper));       
        BinaryOperator<Map<String, Set<String>>> combiner = (map1,map2) -> {map1.forEach((key,value) -> map2.merge(key,value,mapper)); return map2;};
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

    @Difficult @Test
    public void bitList2BitString() {
        String bitList = "22-24,9,42-44,11,4,46,14-17,5,2,38-40,33,50,48";
      
        /**
         * Create a {@link String} of "n"th bit ON.
         * for example
         * "3" will be "001"
         * "1,3,5" will be "10101"
         * "1-3" will be "111"
         * "7,1-3,5" will be "1110101"
         */
        
   
        Collector<String, ?, String> toBitString =  new BitList2BitString();

        String bitString = Arrays.stream(bitList.split(",")).collect(toBitString);
        assertThat(bitString, is("01011000101001111000011100000000100001110111010101")
      
        );
        
       
    }
    
    private class BitList2BitString implements Collector<String, StringBuilder, String>{
     
      private static final String DELIMITER ="-";
      private static final char OFF = '0';
      private static final char ON = '1';
   
      @Override
      public Supplier<StringBuilder> supplier() {
        return StringBuilder::new;
      }

      @Override
      public BiConsumer<StringBuilder, String> accumulator() {
       return (builder,input) -> {
         Range interval = getIntervalFromInputString(input);
         putBitOnForInterval(builder,interval);
       };
        
      }
      /**
       * Read start  and end positions from input.
       * @param input
       * @return an array containing start and end position
       */
      private Range getIntervalFromInputString(String input){
        String[] strInterval = input.split(DELIMITER);
        int startPos = Integer.parseInt(strInterval[0]);
        int endPos = startPos;
        if (strInterval.length >1){
          endPos = Integer.parseInt(strInterval[1]);
        }
        
        return new Range(startPos,endPos);
      }
      /**
       * Switch ON bits in Interval
       * @param builder
       * @param interval
       */
      private void putBitOnForInterval(StringBuilder builder, Range interval){
        
        IntStream.range( builder.length(), interval.endPosition).forEach(i ->builder.append(OFF));
        IntStream.range( interval.startPosition-1, interval.endPosition).forEach(i ->builder.setCharAt(i, ON));
      
      }
      
      @Override
      public BinaryOperator<StringBuilder> combiner() {
        return null;
      }

      @Override
      public Function<StringBuilder, String> finisher() {
        
        return StringBuilder::toString;
      }

      @Override
      public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return Collections.emptySet();
      }
      
    }
}

class Range{
   
  public final int startPosition;
  public final int endPosition;
  
  Range(int start, int end){
    startPosition = start;
    endPosition = end;
  }
  
  
  
}


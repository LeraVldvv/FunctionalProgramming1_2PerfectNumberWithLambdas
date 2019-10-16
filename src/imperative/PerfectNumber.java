package imperative;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PerfectNumber {
    public static Set<Integer> devisors(int n){
        Stream<Integer> stream = IntStream.range(1,n).filter(i -> n % i == 0).boxed();
        Set<Integer> streamSet = stream.collect(Collectors.toSet());

        int sum =IntStream.range(1,n).filter(i -> n % i == 0).sum();
        //  List<Integer> newlist= IntStream.boxed().collect(Collectors.toList())
        return streamSet;
    }


    public enum State{
        DEFICIENT,
        ABUNDANT,
        PERFECT

    }
    public static State Process(int userNumber ){
        Set<Integer> set1= devisors(userNumber);
        IntStream intStream = set1.stream().mapToInt(value -> value);
        int sum= intStream.sum();

        return sum==userNumber? State.PERFECT:ProcessIfNotEqual(sum,userNumber);
    }
    public static State ProcessIfNotEqual (int sum, int userNumber){
        return sum>userNumber? State.ABUNDANT:State.DEFICIENT;
    }
    public static void main(String[] args) {
    }
}
// Comparator<Integer> comparator = (p1, p2) ->;
// comparator.compare(sum,userNumber);

// BiPredicate<Integer, Integer> bi = (xxx, y) -> xxx == y;
// boolean result = bi.test(devisors(userNumber), (userNumber));


//  Function<Boolean,State> half = result1 -> State.ST1;
//     half.apply(result);
//    Converter<Boolean,State> stringConverter1 = (from) -> {
//    return State.ST1;


// State newState=  stringConverter1.convert(result);

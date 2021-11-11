package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TotalSampleVenkat {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValue(numbers, e -> true));
        System.out.println(totalValue(numbers, e -> e % 2 == 0));
        System.out.println(totalValue(numbers, e -> e % 2 != 0));
    }

    private static int totalValue(List<Integer> numbers, Predicate<Integer> selector) {

        int total = 0;

        for(int e : numbers) {
            if(selector.test(e)){
                total += e;
            }
        }
        return total;
    }
}

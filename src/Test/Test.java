package Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 5};

        final Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        System.out.println(collect);
    }
}

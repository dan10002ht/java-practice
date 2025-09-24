import java.util.Arrays;

public class P1_2_Compare {
    static public int sumEvenNumbersV1(int[] arr) {
        int total = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                total += num;
            }
        }
        return total;
    }
    // => O(n)

    static public int sumEvenNumbersV2(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .sum();
    }
    // => O(n)

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(sumEvenNumbersV1(arr));
        System.out.println(sumEvenNumbersV2(arr));
    }
}

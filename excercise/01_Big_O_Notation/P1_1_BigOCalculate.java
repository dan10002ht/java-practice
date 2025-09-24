// Bài 1: Phân tích độ phức tạp thời gian và không gian của hàm trên

public class P1_1_BigOCalculate {
    public int mysteryFunction(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                result += arr[i] * arr[j];
            }
        }
        return result;
    }
}
// => O(n^2)
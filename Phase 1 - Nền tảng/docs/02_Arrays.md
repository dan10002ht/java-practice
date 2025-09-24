# Arrays (Mảng) - Cấu trúc dữ liệu cơ bản

## Giới thiệu

Mảng (Array) là một trong những cấu trúc dữ liệu cơ bản nhất trong lập trình. Nó là một tập hợp các phần tử cùng kiểu dữ liệu được lưu trữ liên tiếp trong bộ nhớ.

## Khái niệm cơ bản

### Định nghĩa

Mảng là cấu trúc dữ liệu tuyến tính chứa các phần tử cùng kiểu, được truy cập thông qua chỉ số (index).

### Đặc điểm

- **Kích thước cố định**: Khi khai báo, kích thước không thể thay đổi
- **Truy cập ngẫu nhiên**: O(1) - truy cập trực tiếp qua index
- **Lưu trữ liên tiếp**: Các phần tử được lưu trữ liền kề nhau trong bộ nhớ
- **Kiểu dữ liệu đồng nhất**: Tất cả phần tử cùng kiểu

## Khai báo và khởi tạo mảng trong Java

### 1. Khai báo cơ bản

```java
// Khai báo mảng kiểu int
int[] numbers;
int numbers[];  // Cách viết khác (ít dùng)

// Khai báo mảng kiểu String
String[] names;
```

### 2. Khởi tạo mảng

```java
// Khởi tạo với kích thước
int[] numbers = new int[5];  // Mảng 5 phần tử, giá trị mặc định là 0

// Khởi tạo với giá trị
int[] numbers = {1, 2, 3, 4, 5};
int[] numbers = new int[]{1, 2, 3, 4, 5};

// Khởi tạo mảng 2 chiều
int[][] matrix = new int[3][4];  // Ma trận 3x4
int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
```

### 3. Truy cập và thao tác

```java
int[] arr = {10, 20, 30, 40, 50};

// Truy cập phần tử
int first = arr[0];    // 10
int last = arr[4];     // 50
int length = arr.length; // 5

// Thay đổi giá trị
arr[2] = 35;  // arr = {10, 20, 35, 40, 50}

// Duyệt mảng
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// Enhanced for loop
for (int num : arr) {
    System.out.println(num);
}
```

## Độ phức tạp của các thao tác

| Thao tác          | Time Complexity | Space Complexity | Ghi chú                      |
| ----------------- | --------------- | ---------------- | ---------------------------- |
| Truy cập (Access) | O(1)            | O(1)             | Truy cập trực tiếp qua index |
| Tìm kiếm (Search) | O(n)            | O(1)             | Phải duyệt từng phần tử      |
| Chèn (Insert)     | O(n)            | O(1)             | Phải dịch chuyển các phần tử |
| Xóa (Delete)      | O(n)            | O(1)             | Phải dịch chuyển các phần tử |
| Cập nhật (Update) | O(1)            | O(1)             | Truy cập trực tiếp           |

## Các dạng bài tập phổ biến

### 1. Two Pointers Technique

**Khái niệm**: Sử dụng hai con trỏ để duyệt mảng từ hai đầu hoặc cùng một đầu.

**Ví dụ**: Tìm cặp số có tổng bằng target

```java
public int[] twoSum(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            return new int[]{left, right};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{-1, -1};  // Không tìm thấy
}
```

**Các bài tập Two Pointers**:

- Valid Palindrome
- Container With Most Water
- Remove Duplicates from Sorted Array
- Move Zeroes

### 2. Sliding Window Technique

**Khái niệm**: Sử dụng cửa sổ trượt để tìm subarray/substring tối ưu.

**Ví dụ**: Tìm subarray có tổng lớn nhất với độ dài k

```java
public int maxSumSubarray(int[] nums, int k) {
    int maxSum = 0;
    int windowSum = 0;

    // Tính tổng cửa sổ đầu tiên
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    maxSum = windowSum;

    // Trượt cửa sổ
    for (int i = k; i < nums.length; i++) {
        windowSum = windowSum - nums[i - k] + nums[i];
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

**Các bài tập Sliding Window**:

- Maximum Sum Subarray of Size K
- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Find All Anagrams in a String

### 3. Prefix Sum

**Khái niệm**: Tính tổng tích lũy để truy vấn tổng subarray nhanh.

**Ví dụ**: Tính tổng subarray từ index i đến j

```java
public class PrefixSum {
    private int[] prefixSum;

    public PrefixSum(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int rangeSum(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

**Các bài tập Prefix Sum**:

- Subarray Sum Equals K
- Range Sum Query - Immutable
- Continuous Subarray Sum
- Product of Array Except Self

### 4. Kadane's Algorithm

**Khái niệm**: Tìm subarray có tổng lớn nhất (Maximum Subarray).

```java
public int maxSubarraySum(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
        maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
}
```

## Mảng 2 chiều (2D Arrays)

### Khái niệm

Mảng 2 chiều là mảng của các mảng, thường được sử dụng để biểu diễn ma trận.

### Khai báo và sử dụng

```java
// Khai báo ma trận 3x4
int[][] matrix = new int[3][4];

// Khởi tạo với giá trị
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// Truy cập phần tử
int value = matrix[1][2];  // 7

// Duyệt ma trận
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

### Các thao tác phổ biến với ma trận

```java
// Xoay ma trận 90 độ
public void rotateMatrix(int[][] matrix) {
    int n = matrix.length;

    // Transpose
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    // Reverse each row
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - 1 - j];
            matrix[i][n - 1 - j] = temp;
        }
    }
}
```

## Dynamic Arrays (ArrayList)

### Khái niệm

ArrayList là mảng động có thể thay đổi kích thước tự động.

### So sánh Array vs ArrayList

| Đặc điểm    | Array     | ArrayList            |
| ----------- | --------- | -------------------- |
| Kích thước  | Cố định   | Động                 |
| Performance | Nhanh hơn | Chậm hơn một chút    |
| Memory      | Ít hơn    | Nhiều hơn (overhead) |
| Flexibility | Thấp      | Cao                  |

### Sử dụng ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Khởi tạo
        List<Integer> list = new ArrayList<>();

        // Thêm phần tử
        list.add(1);
        list.add(2);
        list.add(3);

        // Truy cập
        int first = list.get(0);  // 1

        // Cập nhật
        list.set(1, 5);  // {1, 5, 3}

        // Xóa
        list.remove(0);  // {5, 3}

        // Kích thước
        int size = list.size();  // 2

        // Duyệt
        for (int num : list) {
            System.out.println(num);
        }
    }
}
```

## Các thuật toán sắp xếp cơ bản

### 1. Bubble Sort - O(n²)

```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

### 2. Selection Sort - O(n²)

```java
public void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        // Swap
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
```

### 3. Insertion Sort - O(n²)

```java
public void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

## Bài tập thực hành

### Bài 1: Two Sum

```java
// Tìm hai số có tổng bằng target
public int[] twoSum(int[] nums, int target) {
    // TODO: Implement using HashMap for O(n) solution
    // Hint: Use complement approach
}
```

### Bài 2: Maximum Subarray

```java
// Tìm subarray có tổng lớn nhất
public int maxSubArray(int[] nums) {
    // TODO: Implement Kadane's algorithm
}
```

### Bài 3: Rotate Array

```java
// Xoay mảng k bước
public void rotate(int[] nums, int k) {
    // TODO: Implement array rotation
    // Hint: Use reverse technique
}
```

### Bài 4: Product of Array Except Self

```java
// Tích của tất cả phần tử trừ chính nó
public int[] productExceptSelf(int[] nums) {
    // TODO: Implement without division
    // Hint: Use prefix and suffix products
}
```

## Tips và Tricks

### 1. Xử lý Index Out of Bounds

```java
// Luôn kiểm tra bounds
if (i >= 0 && i < arr.length) {
    // Safe to access arr[i]
}
```

### 2. Swap Elements

```java
// Cách swap an toàn
public void swap(int[] arr, int i, int j) {
    if (i != j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### 3. Reverse Array

```java
public void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        swap(arr, left, right);
        left++;
        right--;
    }
}
```

### 4. Find Min/Max

```java
public int findMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
        min = Math.min(min, arr[i]);
    }
    return min;
}
```

## Common Pitfalls

### 1. Off-by-one Errors

```java
// Sai: i <= arr.length
for (int i = 0; i <= arr.length; i++) {
    // IndexOutOfBoundsException
}

// Đúng: i < arr.length
for (int i = 0; i < arr.length; i++) {
    // Safe
}
```

### 2. Array Initialization

```java
// Sai: Khai báo nhưng không khởi tạo
int[] arr;
arr[0] = 1;  // Compilation error

// Đúng: Khởi tạo trước khi sử dụng
int[] arr = new int[5];
arr[0] = 1;  // OK
```

### 3. Shallow vs Deep Copy

```java
// Shallow copy
int[] original = {1, 2, 3};
int[] copy = original;  // Cùng reference

// Deep copy
int[] deepCopy = original.clone();
// hoặc
int[] deepCopy = Arrays.copyOf(original, original.length);
```

## Tóm tắt

Mảng là cấu trúc dữ liệu cơ bản với:

- **Truy cập nhanh**: O(1) qua index
- **Kích thước cố định**: Cần biết trước
- **Lưu trữ liên tiếp**: Hiệu quả về memory
- **Nhiều kỹ thuật**: Two Pointers, Sliding Window, Prefix Sum

**Lưu ý quan trọng**:

- Luôn kiểm tra bounds khi truy cập
- Sử dụng ArrayList khi cần kích thước động
- Nắm vững các kỹ thuật Two Pointers và Sliding Window
- Practice với các bài tập LeetCode về Arrays

---

**Tiếp theo**: Hãy chuyển sang học về [Strings](../Phase%201%20-%20Nền%20tảng/03_Strings.md) để tiếp tục Phase 1!

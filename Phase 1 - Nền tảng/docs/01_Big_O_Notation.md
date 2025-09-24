# Big O Notation - Phân tích độ phức tạp thuật toán

## Giới thiệu

Big O Notation là một cách để mô tả hiệu suất của thuật toán theo thời gian và không gian. Nó giúp chúng ta so sánh và đánh giá hiệu quả của các thuật toán khác nhau.

## Khái niệm cơ bản

### Định nghĩa

Big O Notation mô tả **worst-case scenario** (trường hợp xấu nhất) của thuật toán, cho biết thuật toán sẽ chậm như thế nào khi kích thước dữ liệu đầu vào tăng lên.

### Công thức

```
T(n) = O(f(n))
```

Trong đó:

- `T(n)`: Thời gian thực thi của thuật toán
- `f(n)`: Hàm mô tả độ phức tạp
- `n`: Kích thước dữ liệu đầu vào

## Các loại độ phức tạp phổ biến

### 1. O(1) - Constant Time

- **Mô tả**: Thời gian thực thi không đổi, không phụ thuộc vào kích thước dữ liệu
- **Ví dụ**: Truy cập phần tử trong mảng bằng index
- **Code mẫu**:

```java
public int getFirstElement(int[] arr) {
    return arr[0];  // O(1)
}
```

### 2. O(log n) - Logarithmic Time

- **Mô tả**: Thời gian tăng theo logarit của n
- **Ví dụ**: Binary search, tìm kiếm trong BST
- **Code mẫu**:

```java
public int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;  // O(log n)
}
```

### 3. O(n) - Linear Time

- **Mô tả**: Thời gian tỷ lệ thuận với kích thước dữ liệu
- **Ví dụ**: Tìm kiếm tuyến tính, duyệt mảng
- **Code mẫu**:

```java
public int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;  // O(n)
}
```

### 4. O(n log n) - Linearithmic Time

- **Mô tả**: Kết hợp của O(n) và O(log n)
- **Ví dụ**: Merge sort, heap sort
- **Code mẫu**:

```java
public void mergeSort(int[] arr) {
    if (arr.length <= 1) return;

    int mid = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

    mergeSort(left);
    mergeSort(right);
    merge(arr, left, right);  // O(n log n)
}
```

### 5. O(n²) - Quadratic Time

- **Mô tả**: Thời gian tỷ lệ với bình phương của n
- **Ví dụ**: Bubble sort, selection sort, nested loops
- **Code mẫu**:

```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    // O(n²)
}
```

### 6. O(2ⁿ) - Exponential Time

- **Mô tả**: Thời gian tăng theo cấp số nhân
- **Ví dụ**: Fibonacci naive, subset generation
- **Code mẫu**:

```java
public int fibonacciNaive(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);  // O(2ⁿ)
}
```

### 7. O(n!) - Factorial Time

- **Mô tả**: Thời gian tăng theo giai thừa
- **Ví dụ**: Permutation generation, traveling salesman problem
- **Code mẫu**:

```java
public List<List<Integer>> generatePermutations(int[] arr) {
    List<List<Integer>> result = new ArrayList<>();
    if (arr.length <= 1) {
        result.add(Arrays.asList(arr[0]));
        return result;
    }

    for (int i = 0; i < arr.length; i++) {
        int[] rest = new int[arr.length - 1];
        System.arraycopy(arr, 0, rest, 0, i);
        System.arraycopy(arr, i + 1, rest, i, arr.length - i - 1);

        List<List<Integer>> perms = generatePermutations(rest);
        for (List<Integer> perm : perms) {
            List<Integer> newPerm = new ArrayList<>();
            newPerm.add(arr[i]);
            newPerm.addAll(perm);
            result.add(newPerm);
        }
    }
    return result;  // O(n!)
}
```

## So sánh độ phức tạp

| Độ phức tạp | Tên gọi      | n=10      | n=100      | n=1000      |
| ----------- | ------------ | --------- | ---------- | ----------- |
| O(1)        | Constant     | 1         | 1          | 1           |
| O(log n)    | Logarithmic  | 3         | 7          | 10          |
| O(n)        | Linear       | 10        | 100        | 1000        |
| O(n log n)  | Linearithmic | 33        | 664        | 9966        |
| O(n²)       | Quadratic    | 100       | 10,000     | 1,000,000   |
| O(2ⁿ)       | Exponential  | 1024      | 1.27×10³⁰  | 1.07×10³⁰¹  |
| O(n!)       | Factorial    | 3,628,800 | 9.33×10¹⁵⁷ | 4.02×10²⁵⁶⁷ |

## Space Complexity (Độ phức tạp không gian)

### Khái niệm

Mô tả lượng bộ nhớ mà thuật toán sử dụng theo kích thước dữ liệu đầu vào.

### Ví dụ

```java
// O(1) space - chỉ sử dụng biến tạm
public int findMax(int[] arr) {
    int maxVal = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > maxVal) {
            maxVal = arr[i];
        }
    }
    return maxVal;
}

// O(n) space - tạo mảng mới
public int[] reverseArray(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[arr.length - 1 - i];
    }
    return result;
}
```

## Quy tắc tính toán Big O

### 1. Loại bỏ hằng số

```java
// O(2n) → O(n)
public void example1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {  // O(n)
        System.out.println(arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {  // O(n)
        System.out.println(arr[i]);
    }
}

// O(n + 5) → O(n)
public void example2(int[] arr) {
    System.out.println("Hello");  // O(1)
    for (int i = 0; i < arr.length; i++) {  // O(n)
        System.out.println(arr[i]);
    }
    System.out.println("World");  // O(1)
}
```

### 2. Loại bỏ số hạng không quan trọng

```java
// O(n² + n) → O(n²)
public void example3(int[] arr) {
    for (int i = 0; i < arr.length; i++) {  // O(n²)
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[i] + " " + arr[j]);
        }
    }

    for (int i = 0; i < arr.length; i++) {  // O(n)
        System.out.println(arr[i]);
    }
}
```

### 3. Quy tắc nhân

```java
// O(n * m) - nested loops với kích thước khác nhau
public void example4(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {  // O(n)
        for (int j = 0; j < arr2.length; j++) {  // O(m)
            System.out.println(arr1[i] + " " + arr2[j]);
        }
    }
}
```

### 4. Quy tắc cộng

```java
// O(n + m) - sequential operations
public void example5(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {  // O(n)
        System.out.println(arr1[i]);
    }

    for (int j = 0; j < arr2.length; j++) {  // O(m)
        System.out.println(arr2[j]);
    }
}
```

## Các trường hợp đặc biệt

### Best Case, Average Case, Worst Case

```java
public int searchInArray(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;  // Best case: O(1) nếu target ở đầu
        }
    }
    return -1;  // Worst case: O(n) nếu target không tồn tại
}
```

### Amortized Analysis

```java
// Dynamic array (Java ArrayList)
// Insert: O(1) amortized, O(n) worst case
public void dynamicArrayExample() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
        list.add(i);  // Hầu hết O(1), đôi khi O(n) khi resize
    }
}
```

## Ứng dụng thực tế

### 1. Chọn thuật toán phù hợp

- **Dữ liệu nhỏ**: Có thể chấp nhận O(n²)
- **Dữ liệu lớn**: Cần O(n log n) hoặc O(n)
- **Real-time**: Cần O(1) hoặc O(log n)

### 2. Tối ưu hóa code

```java
// O(n²) - không hiệu quả
public boolean findDuplicatesSlow(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                return true;
            }
        }
    }
    return false;
}

// O(n) - hiệu quả hơn
public boolean findDuplicatesFast(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    for (int num : arr) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    return false;
}
```

## Bài tập thực hành

### Bài 1: Phân tích độ phức tạp

```java
public int mysteryFunction(int[] arr) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
        for (int j = i; j < arr.length; j++) {
            result += arr[i] * arr[j];
        }
    }
    return result;
}
```

**Câu hỏi**: Độ phức tạp thời gian và không gian của hàm trên là gì?

### Bài 2: So sánh hiệu suất

```java
// Cách 1
public int sumEvenNumbersV1(int[] arr) {
    int total = 0;
    for (int num : arr) {
        if (num % 2 == 0) {
            total += num;
        }
    }
    return total;
}

// Cách 2
public int sumEvenNumbersV2(int[] arr) {
    return Arrays.stream(arr)
                 .filter(num -> num % 2 == 0)
                 .sum();
}
```

**Câu hỏi**: So sánh độ phức tạp của hai cách trên?

## Tóm tắt

Big O Notation là công cụ quan trọng để:

- **Đánh giá hiệu suất** thuật toán
- **So sánh** các giải pháp khác nhau
- **Tối ưu hóa** code
- **Dự đoán** hiệu suất với dữ liệu lớn

**Lưu ý quan trọng**:

- Big O mô tả **worst-case scenario**
- Chỉ quan tâm đến **kích thước dữ liệu lớn**
- **Loại bỏ hằng số** và số hạng không quan trọng
- Cân nhắc cả **time complexity** và **space complexity**

---

**Tiếp theo**: Hãy chuyển sang học về [Arrays](../Phase%201%20-%20Nền%20tảng/02_Arrays.md) để áp dụng kiến thức Big O vào thực tế!

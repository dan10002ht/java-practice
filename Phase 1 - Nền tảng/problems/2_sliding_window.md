# Sliding Window Technique - Kỹ thuật cửa sổ trượt

## Giới thiệu

Sliding Window là một kỹ thuật quan trọng trong lập trình, sử dụng một "cửa sổ" để duyệt qua mảng hoặc chuỗi một cách hiệu quả. Kỹ thuật này giúp giảm độ phức tạp từ O(n²) xuống O(n) trong nhiều trường hợp.

## Khái niệm cơ bản

### Định nghĩa

Sliding Window sử dụng hai con trỏ (left và right) để tạo thành một "cửa sổ" di chuyển qua cấu trúc dữ liệu, thường để tìm subarray hoặc substring tối ưu.

### Các loại Sliding Window

#### 1. Fixed Size Window (Cửa sổ cố định)

- Kích thước cửa sổ không đổi
- **Độ phức tạp**: O(n)
- **Ví dụ**: Tìm subarray có tổng lớn nhất với độ dài k

#### 2. Variable Size Window (Cửa sổ thay đổi)

- Kích thước cửa sổ thay đổi theo điều kiện
- **Độ phức tạp**: O(n)
- **Ví dụ**: Tìm substring dài nhất không có ký tự trùng lặp

## Cách setup và nhận diện

### Khi nào sử dụng Sliding Window?

1. **Tìm subarray/substring** thỏa mãn điều kiện
2. **Tối ưu hóa** (min/max) trên subarray
3. **Đếm** số lượng subarray thỏa mãn điều kiện
4. **Tìm pattern** trong chuỗi
5. **Xử lý dữ liệu liên tục** (streaming data)

### Template cơ bản

#### Fixed Size Window Template

```java
public int fixedSizeWindow(int[] nums, int k) {
    int windowSum = 0;
    int maxSum = 0;

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

#### Variable Size Window Template

```java
public int variableSizeWindow(int[] nums, int target) {
    int left = 0;
    int windowSum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
        // Mở rộng cửa sổ
        windowSum += nums[right];

        // Thu hẹp cửa sổ khi thỏa mãn điều kiện
        while (windowSum >= target) {
            minLength = Math.min(minLength, right - left + 1);
            windowSum -= nums[left];
            left++;
        }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}
```

## Các bài toán kinh điển

### 1. Maximum Sum Subarray of Size K

**Mô tả**: Tìm subarray có tổng lớn nhất với độ dài k.

**Input**: `nums = [2,1,5,1,3,2], k = 3`
**Output**: `9` (subarray [5,1,3])

```java
public int maxSumSubarray(int[] nums, int k) {
    int windowSum = 0;
    int maxSum = 0;

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

**Độ phức tạp**: O(n), Space: O(1)

### 2. Longest Substring Without Repeating Characters

**Mô tả**: Tìm substring dài nhất không có ký tự trùng lặp.

**Input**: `s = "abcabcbb"`
**Output**: `3` (substring "abc")

```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        // Nếu ký tự đã tồn tại, thu hẹp cửa sổ
        while (window.contains(s.charAt(right))) {
            window.remove(s.charAt(left));
            left++;
        }

        // Thêm ký tự mới vào cửa sổ
        window.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
```

**Độ phức tạp**: O(n), Space: O(min(m,n)) với m là kích thước charset

### 3. Minimum Window Substring

**Mô tả**: Tìm substring ngắn nhất chứa tất cả ký tự của pattern.

**Input**: `s = "ADOBECODEBANC", t = "ABC"`
**Output**: `"BANC"`

```java
public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    // Đếm ký tự cần thiết
    for (char c : t.toCharArray()) {
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0; // Số ký tự đã thỏa mãn
    int start = 0, len = Integer.MAX_VALUE;

    while (right < s.length()) {
        char c = s.charAt(right);
        right++;

        // Cập nhật window
        if (need.containsKey(c)) {
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) {
                valid++;
            }
        }

        // Thu hẹp cửa sổ
        while (valid == need.size()) {
            if (right - left < len) {
                start = left;
                len = right - left;
            }

            char d = s.charAt(left);
            left++;

            if (need.containsKey(d)) {
                if (window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
}
```

**Độ phức tạp**: O(|s| + |t|), Space: O(|s| + |t|)

### 4. Find All Anagrams in a String

**Mô tả**: Tìm tất cả vị trí bắt đầu của anagram của pattern trong string.

**Input**: `s = "cbaebabacd", p = "abc"`
**Output**: `[0,6]`

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    // Đếm ký tự cần thiết
    for (char c : p.toCharArray()) {
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;

    while (right < s.length()) {
        char c = s.charAt(right);
        right++;

        // Cập nhật window
        if (need.containsKey(c)) {
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) {
                valid++;
            }
        }

        // Kiểm tra nếu cửa sổ đủ lớn
        while (right - left >= p.length()) {
            if (valid == need.size()) {
                result.add(left);
            }

            char d = s.charAt(left);
            left++;

            if (need.containsKey(d)) {
                if (window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
    }

    return result;
}
```

**Độ phức tạp**: O(|s| + |p|), Space: O(|s| + |p|)

### 5. Subarray Sum Equals K

**Mô tả**: Đếm số lượng subarray có tổng bằng k.

**Input**: `nums = [1,1,1], k = 2`
**Output**: `2`

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixSum = new HashMap<>();
    prefixSum.put(0, 1); // Tổng rỗng xuất hiện 1 lần

    int count = 0;
    int sum = 0;

    for (int num : nums) {
        sum += num;

        // Nếu tồn tại prefixSum = sum - k
        if (prefixSum.containsKey(sum - k)) {
            count += prefixSum.get(sum - k);
        }

        // Cập nhật prefixSum
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
    }

    return count;
}
```

**Độ phức tạp**: O(n), Space: O(n)

### 6. Longest Repeating Character Replacement

**Mô tả**: Tìm substring dài nhất có thể tạo thành bằng cách thay thế tối đa k ký tự.

**Input**: `s = "AABABBA", k = 1`
**Output**: `4` (substring "AABA" hoặc "ABBA")

```java
public int characterReplacement(String s, int k) {
    Map<Character, Integer> window = new HashMap<>();
    int left = 0;
    int maxCount = 0; // Số ký tự xuất hiện nhiều nhất trong cửa sổ
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c, 0) + 1);
        maxCount = Math.max(maxCount, window.get(c));

        // Nếu cửa sổ không hợp lệ, thu hẹp
        while (right - left + 1 - maxCount > k) {
            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
```

**Độ phức tạp**: O(n), Space: O(1) (vì chỉ có 26 ký tự)

## Tips và Tricks

### 1. Sử dụng HashMap để đếm

```java
Map<Character, Integer> window = new HashMap<>();
window.put(c, window.getOrDefault(c, 0) + 1);
```

### 2. Kiểm tra điều kiện hợp lệ

```java
// Cửa sổ hợp lệ khi: windowSize - maxCount <= k
while (right - left + 1 - maxCount > k) {
    // Thu hẹp cửa sổ
}
```

### 3. Cập nhật kết quả

```java
// Cập nhật kết quả tối ưu
maxLength = Math.max(maxLength, right - left + 1);
```

### 4. Xử lý edge cases

```java
// Luôn kiểm tra mảng/chuỗi rỗng
if (nums.length == 0) return 0;
if (s.length() == 0) return "";
```

## Common Mistakes

### 1. Quên khởi tạo HashMap

```java
// Sai
Map<Character, Integer> window = new HashMap<>();
// Thiếu: window.put(0, 1) cho prefix sum

// Đúng
Map<Integer, Integer> prefixSum = new HashMap<>();
prefixSum.put(0, 1); // Quan trọng!
```

### 2. Sai logic thu hẹp cửa sổ

```java
// Sai: thu hẹp quá sớm
while (condition) {
    left++;
    // Xử lý logic
}

// Đúng: xử lý logic trước khi thu hẹp
while (condition) {
    // Xử lý logic
    left++;
}
```

### 3. Không cập nhật biến đếm

```java
// Sai: quên cập nhật maxCount
window.put(c, window.getOrDefault(c, 0) + 1);

// Đúng: cập nhật maxCount
window.put(c, window.getOrDefault(c, 0) + 1);
maxCount = Math.max(maxCount, window.get(c));
```

## Bài tập luyện tập

### Easy Level

1. **Maximum Sum Subarray of Size K** - LeetCode 209
2. **Longest Substring Without Repeating Characters** - LeetCode 3
3. **Subarray Sum Equals K** - LeetCode 560
4. **Find All Anagrams in a String** - LeetCode 438

### Medium Level

1. **Minimum Window Substring** - LeetCode 76
2. **Longest Repeating Character Replacement** - LeetCode 424
3. **Permutation in String** - LeetCode 567
4. **Fruit Into Baskets** - LeetCode 904

### Hard Level

1. **Sliding Window Maximum** - LeetCode 239
2. **Minimum Window Subsequence** - LeetCode 727
3. **Substring with Concatenation of All Words** - LeetCode 30

## Tóm tắt

Sliding Window là kỹ thuật mạnh mẽ với:

- **Độ phức tạp**: O(n) cho hầu hết bài toán
- **Space**: O(1) đến O(n) tùy thuộc vào cấu trúc dữ liệu phụ
- **Ứng dụng**: Rất rộng rãi trong string/array problems
- **Điều kiện**: Thường cần xử lý subarray/substring

**Lưu ý quan trọng**:

- Hiểu rõ khi nào sử dụng fixed vs variable size window
- Sử dụng HashMap để đếm ký tự/phần tử hiệu quả
- Cẩn thận với logic thu hẹp cửa sổ
- Practice nhiều để nhận diện pattern

---

**Tiếp theo**: Hãy chuyển sang [Prefix Sum](../3_prefix_sum.md) để học kỹ thuật tiếp theo!

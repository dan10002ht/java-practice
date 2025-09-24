# Two Pointers Technique - Kỹ thuật hai con trỏ

## Giới thiệu

Two Pointers là một kỹ thuật quan trọng trong lập trình, sử dụng hai con trỏ để duyệt qua mảng hoặc chuỗi một cách hiệu quả. Kỹ thuật này giúp giảm độ phức tạp từ O(n²) xuống O(n) trong nhiều trường hợp.

## Khái niệm cơ bản

### Định nghĩa

Two Pointers sử dụng hai biến chỉ số (pointers) để duyệt qua cấu trúc dữ liệu, thường bắt đầu từ hai vị trí khác nhau và di chuyển theo các quy tắc nhất định.

### Các loại Two Pointers

#### 1. Opposite Direction (Ngược chiều)

- Hai con trỏ bắt đầu từ hai đầu của mảng
- Di chuyển về phía nhau
- **Độ phức tạp**: O(n)

#### 2. Same Direction (Cùng chiều)

- Hai con trỏ bắt đầu từ cùng một vị trí
- Di chuyển cùng chiều với tốc độ khác nhau
- **Độ phức tạp**: O(n)

## Cách setup và nhận diện

### Khi nào sử dụng Two Pointers?

1. **Mảng đã được sắp xếp**
2. **Tìm cặp phần tử** thỏa mãn điều kiện
3. **Loại bỏ duplicates** trong mảng đã sắp xếp
4. **Palindrome** checking
5. **Container problems** (như Container With Most Water)

### Template cơ bản

#### Opposite Direction Template

```java
public int[] twoPointersOpposite(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        // Logic xử lý
        if (condition) {
            // Xử lý khi tìm thấy kết quả
            return result;
        } else if (arr[left] + arr[right] < target) {
            left++;  // Tăng left pointer
        } else {
            right--; // Giảm right pointer
        }
    }

    return notFound; // Không tìm thấy
}
```

#### Same Direction Template

```java
public int twoPointersSame(int[] arr) {
    int slow = 0;
    int fast = 0;

    while (fast < arr.length) {
        if (condition) {
            // Xử lý logic
            arr[slow] = arr[fast];
            slow++;
        }
        fast++;
    }

    return slow; // Trả về vị trí mới
}
```

## Các bài toán kinh điển

### 1. Two Sum (Sorted Array)

**Mô tả**: Tìm hai số trong mảng đã sắp xếp có tổng bằng target.

**Input**: `nums = [2,7,11,15], target = 9`
**Output**: `[0,1]` (vì nums[0] + nums[1] = 2 + 7 = 9)

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) {
            return new int[]{left + 1, right + 1}; // 1-indexed
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return new int[]{-1, -1};
}
```

**Độ phức tạp**: O(n), Space: O(1)

### 2. Valid Palindrome

**Mô tả**: Kiểm tra xem một chuỗi có phải là palindrome không (bỏ qua ký tự không phải chữ cái và số).

**Input**: `s = "A man, a plan, a canal: Panama"`
**Output**: `true`

```java
public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        // Bỏ qua ký tự không phải alphanumeric
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        // So sánh (case insensitive)
        if (Character.toLowerCase(s.charAt(left)) !=
            Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
```

**Độ phức tạp**: O(n), Space: O(1)

### 3. Container With Most Water

**Mô tả**: Tìm hai đường thẳng tạo thành container chứa được nhiều nước nhất.

**Input**: `height = [1,8,6,2,5,4,8,3,7]`
**Output**: `49`

```java
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
        // Tính diện tích hiện tại
        int width = right - left;
        int currentHeight = Math.min(height[left], height[right]);
        int currentArea = width * currentHeight;
        maxWater = Math.max(maxWater, currentArea);

        // Di chuyển pointer có chiều cao nhỏ hơn
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxWater;
}
```

**Độ phức tạp**: O(n), Space: O(1)

### 4. Remove Duplicates from Sorted Array

**Mô tả**: Loại bỏ các phần tử trùng lặp trong mảng đã sắp xếp, trả về độ dài mới.

**Input**: `nums = [1,1,2,2,3,4,4,5]`
**Output**: `5` (mảng mới: [1,2,3,4,5])

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int slow = 0;
    int fast = 1;

    while (fast < nums.length) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
    }

    return slow + 1;
}
```

**Độ phức tạp**: O(n), Space: O(1)

### 5. Move Zeroes

**Mô tả**: Di chuyển tất cả số 0 về cuối mảng, giữ nguyên thứ tự các số khác.

**Input**: `nums = [0,1,0,3,12]`
**Output**: `[1,3,12,0,0]`

```java
public void moveZeroes(int[] nums) {
    int slow = 0;

    // Di chuyển tất cả số khác 0 lên đầu
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != 0) {
            nums[slow] = nums[fast];
            slow++;
        }
    }

    // Điền 0 vào các vị trí còn lại
    while (slow < nums.length) {
        nums[slow] = 0;
        slow++;
    }
}
```

**Độ phức tạp**: O(n), Space: O(1)

### 6. 3Sum

**Mô tả**: Tìm tất cả bộ ba số có tổng bằng 0.

**Input**: `nums = [-1,0,1,2,-1,-4]`
**Output**: `[[-1,-1,2],[-1,0,1]]`

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
        // Bỏ qua duplicates cho i
        if (i > 0 && nums[i] == nums[i-1]) continue;

        int left = i + 1;
        int right = nums.length - 1;
        int target = -nums[i];

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // Bỏ qua duplicates
                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right] == nums[right-1]) right--;

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    return result;
}
```

**Độ phức tạp**: O(n²), Space: O(1)

## Tips và Tricks

### 1. Luôn kiểm tra điều kiện dừng

```java
while (left < right) {  // Quan trọng!
    // Logic xử lý
}
```

### 2. Xử lý duplicates

```java
// Bỏ qua duplicates
while (left < right && nums[left] == nums[left+1]) {
    left++;
}
```

### 3. Cẩn thận với index

```java
// 1-indexed vs 0-indexed
return new int[]{left + 1, right + 1}; // 1-indexed
return new int[]{left, right};          // 0-indexed
```

### 4. Tối ưu hóa điều kiện

```java
// Thay vì
if (arr[left] + arr[right] == target) {
    // xử lý
} else if (arr[left] + arr[right] < target) {
    left++;
} else {
    right--;
}

// Có thể viết
int sum = arr[left] + arr[right];
if (sum == target) {
    // xử lý
} else if (sum < target) {
    left++;
} else {
    right--;
}
```

## Common Mistakes

### 1. Quên kiểm tra bounds

```java
// Sai
while (left <= right) {  // Có thể gây infinite loop

// Đúng
while (left < right) {
```

### 2. Không xử lý edge cases

```java
// Luôn kiểm tra
if (nums.length < 2) return result;
```

### 3. Sai logic di chuyển pointer

```java
// Sai: di chuyển cả hai pointer
if (condition) {
    left++;
    right--;  // Có thể bỏ lỡ kết quả
}

// Đúng: di chuyển theo logic
if (condition) {
    left++;  // hoặc right--
}
```

## Bài tập luyện tập

### Easy Level

1. **Two Sum II** - LeetCode 167
2. **Valid Palindrome** - LeetCode 125
3. **Remove Duplicates from Sorted Array** - LeetCode 26
4. **Move Zeroes** - LeetCode 283

### Medium Level

1. **Container With Most Water** - LeetCode 11
2. **3Sum** - LeetCode 15
3. **3Sum Closest** - LeetCode 16
4. **Sort Colors** - LeetCode 75

### Hard Level

1. **Trapping Rain Water** - LeetCode 42
2. **4Sum** - LeetCode 18

## Tóm tắt

Two Pointers là kỹ thuật mạnh mẽ với:

- **Độ phức tạp**: O(n) cho hầu hết bài toán
- **Space**: O(1) - không cần thêm bộ nhớ
- **Ứng dụng**: Rất rộng rãi trong array/string problems
- **Điều kiện**: Mảng thường cần được sắp xếp

**Lưu ý quan trọng**:

- Luôn kiểm tra điều kiện dừng
- Xử lý cẩn thận các edge cases
- Practice nhiều để nhận diện pattern
- Hiểu rõ khi nào sử dụng opposite vs same direction

---

**Tiếp theo**: Hãy chuyển sang [Sliding Window](../2_sliding_window.md) để học kỹ thuật tiếp theo!

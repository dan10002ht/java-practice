# DSA (Data Structures & Algorithms) Roadmap

## Mục lục

1. [Giới thiệu](#giới-thiệu)
2. [Lộ trình học tập](#lộ-trình-học-tập)
3. [Cấu trúc dữ liệu cơ bản](#cấu-trúc-dữ-liệu-cơ-bản)
4. [Thuật toán cơ bản](#thuật-toán-cơ-bản)
5. [Cấu trúc dữ liệu nâng cao](#cấu-trúc-dữ-liệu-nâng-cao)
6. [Thuật toán nâng cao](#thuật-toán-nâng-cao)
7. [Các dạng bài tập phổ biến](#các-dạng-bài-tập-phổ-biến)
8. [Tài nguyên học tập](#tài-nguyên-học-tập)
9. [Lịch trình đề xuất](#lịch-trình-đề-xuất)

## Giới thiệu

DSA (Data Structures & Algorithms) là nền tảng quan trọng trong lập trình, giúp bạn:

- Tối ưu hóa hiệu suất code
- Giải quyết các bài toán phức tạp
- Chuẩn bị cho các cuộc phỏng vấn kỹ thuật
- Phát triển tư duy logic và giải quyết vấn đề

## Lộ trình học tập

### Phase 1: Nền tảng (2-3 tuần)

- [ ] Cơ bản về Big O Notation
- [ ] Mảng (Arrays)
- [ ] Chuỗi (Strings)
- [ ] Danh sách liên kết (Linked Lists)

### Phase 2: Cấu trúc dữ liệu cơ bản (3-4 tuần)

- [ ] Stack & Queue
- [ ] Hash Tables
- [ ] Trees (Binary Tree, BST)
- [ ] Graphs cơ bản

### Phase 3: Thuật toán cơ bản (4-5 tuần)

- [ ] Sorting Algorithms
- [ ] Searching Algorithms
- [ ] Recursion
- [ ] Dynamic Programming cơ bản

### Phase 4: Nâng cao (6-8 tuần)

- [ ] Advanced Trees (AVL, Red-Black, Trie)
- [ ] Advanced Graphs
- [ ] Advanced Dynamic Programming
- [ ] Greedy Algorithms
- [ ] Backtracking

## Cấu trúc dữ liệu cơ bản

### 1. Arrays (Mảng)

**Khái niệm**: Cấu trúc dữ liệu tuyến tính lưu trữ các phần tử cùng kiểu dữ liệu.

**Đặc điểm**:

- Truy cập ngẫu nhiên: O(1)
- Tìm kiếm: O(n)
- Chèn/xóa: O(n)

**Các dạng bài**:

- Two Pointers
- Sliding Window
- Prefix Sum
- Kadane's Algorithm

### 2. Strings (Chuỗi)

**Khái niệm**: Dãy các ký tự.

**Các dạng bài**:

- String Manipulation
- Pattern Matching
- Palindrome
- Anagram

### 3. Linked Lists (Danh sách liên kết)

**Khái niệm**: Cấu trúc dữ liệu tuyến tính với các node được liên kết bằng con trỏ.

**Loại**:

- Singly Linked List
- Doubly Linked List
- Circular Linked List

**Các dạng bài**:

- Reverse Linked List
- Detect Cycle
- Merge Two Sorted Lists
- Find Middle Node

### 4. Stack & Queue

**Stack (Ngăn xếp)**:

- LIFO (Last In, First Out)
- Operations: push, pop, peek
- Ứng dụng: Expression evaluation, backtracking

**Queue (Hàng đợi)**:

- FIFO (First In, First Out)
- Operations: enqueue, dequeue, front
- Ứng dụng: BFS, scheduling

### 5. Hash Tables

**Khái niệm**: Cấu trúc dữ liệu ánh xạ key-value.

**Đặc điểm**:

- Average case: O(1) cho search, insert, delete
- Worst case: O(n)

**Các dạng bài**:

- Two Sum
- Group Anagrams
- Longest Substring Without Repeating Characters

## Trees (Cây)

### 1. Binary Tree

**Khái niệm**: Cây có tối đa 2 con cho mỗi node.

**Traversal**:

- Preorder: Root → Left → Right
- Inorder: Left → Root → Right
- Postorder: Left → Right → Root
- Level Order (BFS)

### 2. Binary Search Tree (BST)

**Đặc điểm**:

- Left child < Parent < Right child
- Search: O(log n) average, O(n) worst
- Insert/Delete: O(log n) average

### 3. Advanced Trees

- **AVL Tree**: Self-balancing BST
- **Red-Black Tree**: Self-balancing BST với color properties
- **Trie**: Tree cho string operations
- **Segment Tree**: Range queries
- **Fenwick Tree**: Prefix sums

## Graphs (Đồ thị)

### 1. Representation

- **Adjacency Matrix**: O(V²) space
- **Adjacency List**: O(V + E) space

### 2. Traversal

- **DFS (Depth-First Search)**: Stack-based
- **BFS (Breadth-First Search)**: Queue-based

### 3. Shortest Path

- **Dijkstra's Algorithm**: Single source, non-negative weights
- **Bellman-Ford**: Single source, negative weights allowed
- **Floyd-Warshall**: All pairs shortest path

### 4. Minimum Spanning Tree

- **Kruskal's Algorithm**: Greedy approach
- **Prim's Algorithm**: Greedy approach

## Thuật toán cơ bản

### 1. Sorting Algorithms

| Algorithm      | Best       | Average    | Worst      | Space    | Stable |
| -------------- | ---------- | ---------- | ---------- | -------- | ------ |
| Bubble Sort    | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Selection Sort | O(n²)      | O(n²)      | O(n²)      | O(1)     | No     |
| Insertion Sort | O(n)       | O(n²)      | O(n²)      | O(1)     | Yes    |
| Merge Sort     | O(n log n) | O(n log n) | O(n log n) | O(n)     | Yes    |
| Quick Sort     | O(n log n) | O(n log n) | O(n²)      | O(log n) | No     |
| Heap Sort      | O(n log n) | O(n log n) | O(n log n) | O(1)     | No     |

### 2. Searching Algorithms

- **Linear Search**: O(n)
- **Binary Search**: O(log n)
- **Ternary Search**: O(log₃ n)

### 3. Recursion

**Nguyên tắc**:

- Base case
- Recursive case
- Progress toward base case

**Các dạng**:

- Tail Recursion
- Head Recursion
- Tree Recursion
- Indirect Recursion

## Các dạng bài tập phổ biến

### 1. Array Problems

- **Two Pointers**: Valid Palindrome, Container With Most Water
- **Sliding Window**: Longest Substring Without Repeating Characters
- **Prefix Sum**: Subarray Sum Equals K
- **Kadane's Algorithm**: Maximum Subarray

### 2. String Problems

- **Pattern Matching**: Implement strStr()
- **Palindrome**: Valid Palindrome, Longest Palindromic Substring
- **Anagram**: Group Anagrams, Valid Anagram
- **String Manipulation**: Reverse Words in a String

### 3. Linked List Problems

- **Basic Operations**: Reverse Linked List, Merge Two Sorted Lists
- **Cycle Detection**: Linked List Cycle, Find the Duplicate Number
- **Advanced**: Copy List with Random Pointer, LRU Cache

### 4. Tree Problems

- **Traversal**: Binary Tree Inorder Traversal, Level Order Traversal
- **Path Problems**: Path Sum, Binary Tree Maximum Path Sum
- **Construction**: Construct Binary Tree from Preorder and Inorder
- **Validation**: Validate Binary Search Tree

### 5. Graph Problems

- **Traversal**: Number of Islands, Course Schedule
- **Shortest Path**: Network Delay Time, Cheapest Flights Within K Stops
- **Topological Sort**: Course Schedule II
- **Union Find**: Number of Connected Components

### 6. Dynamic Programming

- **1D DP**: Climbing Stairs, House Robber
- **2D DP**: Unique Paths, Edit Distance
- **Knapsack**: 0/1 Knapsack, Coin Change
- **LCS**: Longest Common Subsequence
- **LIS**: Longest Increasing Subsequence

### 7. Greedy Algorithms

- **Activity Selection**: Meeting Rooms
- **Huffman Coding**: Minimum Cost to Connect Sticks
- **Fractional Knapsack**: Gas Station

### 8. Backtracking

- **Permutations**: Permutations, Permutations II
- **Combinations**: Combinations, Combination Sum
- **N-Queens**: N-Queens, Sudoku Solver

## Tài nguyên học tập

### Websites

- **LeetCode**: https://leetcode.com/
- **HackerRank**: https://www.hackerrank.com/
- **Codeforces**: https://codeforces.com/
- **AtCoder**: https://atcoder.jp/
- **GeeksforGeeks**: https://www.geeksforgeeks.org/

### Books

- "Introduction to Algorithms" - Cormen, Leiserson, Rivest, Stein
- "Algorithm Design Manual" - Steven Skiena
- "Cracking the Coding Interview" - Gayle McDowell
- "Elements of Programming Interviews" - Aziz, Lee, Prakash

### YouTube Channels

- Abdul Bari
- Back To Back SWE
- NeetCode
- Tech With Tim

## Lịch trình đề xuất

### Tuần 1-2: Arrays & Strings

- **Ngày 1-3**: Arrays cơ bản, Two Pointers
- **Ngày 4-7**: Sliding Window, Prefix Sum
- **Ngày 8-10**: String manipulation
- **Ngày 11-14**: Practice problems

### Tuần 3-4: Linked Lists & Stacks/Queues

- **Ngày 15-17**: Linked List operations
- **Ngày 18-21**: Stack & Queue applications
- **Ngày 22-24**: Hash Tables
- **Ngày 25-28**: Practice problems

### Tuần 5-7: Trees

- **Ngày 29-31**: Binary Tree traversal
- **Ngày 32-35**: Binary Search Tree
- **Ngày 36-38**: Tree construction problems
- **Ngày 39-42**: Advanced tree problems
- **Ngày 43-49**: Practice problems

### Tuần 8-10: Graphs

- **Ngày 50-52**: Graph representation & traversal
- **Ngày 53-56**: DFS & BFS applications
- **Ngày 57-59**: Shortest path algorithms
- **Ngày 60-63**: Minimum spanning tree
- **Ngày 64-70**: Practice problems

### Tuần 11-13: Dynamic Programming

- **Ngày 71-73**: 1D DP basics
- **Ngày 74-77**: 2D DP
- **Ngày 78-80**: Knapsack problems
- **Ngày 81-84**: LCS & LIS
- **Ngày 85-91**: Practice problems

### Tuần 14-16: Advanced Topics

- **Ngày 92-94**: Greedy algorithms
- **Ngày 95-98**: Backtracking
- **Ngày 99-101**: Advanced data structures
- **Ngày 102-105**: System design basics
- **Ngày 106-112**: Mock interviews & review

## Tips học tập hiệu quả

### 1. Thực hành đều đặn

- Giải ít nhất 1-2 bài mỗi ngày
- Tập trung vào chất lượng hơn số lượng
- Review lại các bài đã làm

### 2. Hiểu sâu, không chỉ thuộc lòng

- Hiểu tại sao thuật toán hoạt động
- Phân tích time/space complexity
- Tự implement lại từ đầu

### 3. Pattern Recognition

- Nhận diện các pattern phổ biến
- Tạo template cho từng dạng bài
- Practice với các biến thể

### 4. Mock Interview

- Luyện tập giải thích ý tưởng
- Code trên whiteboard/giấy
- Time management

## Mục tiêu theo từng giai đoạn

### Beginner (0-3 tháng)

- [ ] Hiểu Big O Notation
- [ ] Thành thạo Arrays, Strings, Linked Lists
- [ ] Biết sử dụng Stack, Queue, Hash Table
- [ ] Giải được 50+ bài LeetCode Easy

### Intermediate (3-6 tháng)

- [ ] Thành thạo Trees và Graphs
- [ ] Hiểu và implement các sorting algorithms
- [ ] Biết cơ bản về Dynamic Programming
- [ ] Giải được 100+ bài LeetCode Medium

### Advanced (6-12 tháng)

- [ ] Thành thạo Advanced DP patterns
- [ ] Hiểu các advanced data structures
- [ ] Biết Greedy và Backtracking
- [ ] Giải được 50+ bài LeetCode Hard
- [ ] Sẵn sàng cho technical interviews

## Checklist hàng ngày

- [ ] Đọc 1 bài lý thuyết mới
- [ ] Giải 1-2 bài practice
- [ ] Review bài đã làm trước đó
- [ ] Ghi chú các pattern mới học được
- [ ] Update progress trong roadmap

---

**Lưu ý**: Roadmap này có thể điều chỉnh tùy theo tốc độ học và mục tiêu cá nhân. Quan trọng nhất là duy trì tính nhất quán và thực hành đều đặn!

**Chúc bạn học tập hiệu quả!**

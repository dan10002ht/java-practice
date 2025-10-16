import java.util.HashSet;
import java.util.Set;

/*
    Given a string s, find the length of the longest substring without duplicate characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Nếu ký tự hiện tại đã tồn tại trong window
            while (window.contains(s.charAt(right))) {
                // Remove ký tự ở left cho đến khi không còn trùng lặp
                window.remove(s.charAt(left));
                left++;
            }
            // Thêm ký tự hiện tại vào window
            window.add(s.charAt(right));
            // Cập nhật maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
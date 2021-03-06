//Given a string S of lowercase letters, a duplicate removal consists of choosin
//g two adjacent and equal letters, and removing them. 
//
// We repeatedly make duplicate removals on S until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed the answer is unique. 
//
// 
//
// Example 1: 
//
// 
//Input: "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent a
//nd equal, and this is the only possible move.  The result of this move is that t
//he string is "aaca", of which only "aa" is possible, so the final string is "ca"
//.
// 
//
// 
//
// Note: 
//
// 
// 1 <= S.length <= 20000 
// S consists only of English lowercase letters. 
// Related Topics Stack 
// 👍 788 👎 62

package leetcode.editor.en;

// 2020-07-26 12:26:47
// Zeshi Yang
public class Leetcode1047RemoveAllAdjacentDuplicatesInString{
    // Java: remove-all-adjacent-duplicates-in-string
    public static void main(String[] args) {
        Solution sol = new Leetcode1047RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
        
        System.out.println();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        char[] words = S.toCharArray();

        // [0, slow] no adjacent duplicate so far
        // (slow, fast) explored and will be removed
        //[fast, length) to be checked
        //
        int slow = -1;
        int fast = 0;
        int length = words.length;
        while(fast < length) {
            if (slow == -1) {
                slow++;
                words[slow] = words[fast];
                fast++;
            }
            else if (words[fast] == words[slow]) {
                fast++;
                slow--;
            }
            else {
                slow++;
                words[slow] = words[fast];
                fast++;
            }
        }
        length = slow + 1;
        S = new String(words, 0, length);
        return S;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
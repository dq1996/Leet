package LeetCode._面试题_01_06_字符串压缩;

/*
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 
 * 示例1:
 *  输入：
 *  "aabcccccaaa"
 *  输出：
 *  "a2b1c5a3"
 *  
 *  示例2:
 *  输入：
 *  "abbccd"
 *  输出：
 *  "abbccd"
 *  
 *  解释：
 *  "abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *  
 *  提示：
 *  字符串长度在[0, 50000]范围内。
 */

/*
 * 思路：
 * 遍历，不断使用后一元素与当前元素进行比较
 * 新元素时重置
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution {

	public static String compressString(String S) {
		if (S.length() == 0) {
			return S;
		}
		StringBuffer compressStr = new StringBuffer();
		int count = 1;
		char cur = S.charAt(0);
		compressStr.append(cur);
		for (int i = 1;i < S.length(); i ++) {
			//下一个元素重复，使用当前i可避免数组越界
			if (S.charAt(i) == cur) {
				count ++;
			}
			//下一个元素不重复，重置当前元素和元素个数
			else {
				compressStr.append(count);//上一个元素的元素个数
				compressStr.append(S.charAt(i));
				cur = S.charAt(i);
				count = 1;
			}
		}
		compressStr.append(count);//最后一个元素的元素个数
		if (compressStr.length() >= S.length()) {
			return S;
		}
		return compressStr.toString();
    }
	public static void main(String[] args) {
		String S = "aabcccccaaa";
		S = compressString(S);
		System.out.println(S);
	}

}

package LeetCode._1071_字符串的最大公因子;

import java.math.BigInteger;

/*
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 
 * 示例 1：
 * 输入：
 * str1 = "ABCABC", str2 = "ABC"
 * 输出：
 * "ABC"
 * 
 * 示例 2：
 * 输入：
 * str1 = "ABABAB", str2 = "ABAB"
 * 输出：
 * "AB"
 * 
 * 示例 3：
 * 输入：
 * str1 = "LEET", str2 = "CODE"
 * 输出：
 * ""
 * 
 * 提示：
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */

/*
 * 思路：
 * 1、通过正反拼接字符串，判断满足条件的公因字符串是否存在；
 * 2、利用gcd函数求得两字符串长度的最大公约数；
 * 3、在某一字符串头部取得该长度的子串。
 * 
 * 时间复杂度O(n)、创建临时字符串变量，空间复杂度O(n)
 */
public class Solution2_数学法 {
	
	public static String gcdOfStrings(String str1, String str2) {
		//判断满足条件的公因字符串是否存在
		if (! (str1 + str2).equals(str2 + str1)) {
			return "";
		}
		BigInteger len1 = BigInteger.valueOf(str1.length());
		BigInteger len2 = BigInteger.valueOf(str2.length());
		//利用BigInteger自带的gcd函数求解两字符串长度的最大公约数
		int gcd = len1.gcd(len2).intValue();
		//若存在最大公因字符串，取到的str1中该长度的gcdString其实必是
		String gcdString = str1.substring(0, gcd);
		return gcdString;
    }
	
	public static void main(String[] args) {
		String str1 = "ABABAB";
		String str2 = "ABAB";
		String gcd = gcdOfStrings(str1, str2);
		System.out.println(gcd);
	}
}

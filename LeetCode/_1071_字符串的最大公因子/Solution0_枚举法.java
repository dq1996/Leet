package LeetCode._1071_字符串的最大公因子;

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
 * 1、先求得两字符串长度的最大公约数；
 * 2、在某一字符串中枚举该长度的子串；
 * 3、判断该子串在两字符串中是否连续重复。
 * 
 * 时间复杂度O(n)、创建临时字符串变量repeat，空间复杂度O(n)
 */
public class Solution0_枚举法 {
	
	private static boolean ifRepeat(String str, String gcdString) {
		int repeatTimes = str.length() / gcdString.length();
		//新的拼接字符串
		String repeat = "";
		for (int i = 0; i < repeatTimes; i ++) {
			repeat += gcdString;
		}
		//判断两字符串相等不要用==，要用equals
		if (repeat.equals(str)) {
			return true;
		}
		return false;
	}
	public static String gcdOfStrings(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		String gcdString = "";
		for (int i = Math.min(len1, len2); i >= 1; i --) {
			//i为两个字符串长度的最大公约数
			if (len1 % i == 0 && len2 % i == 0) {
				gcdString = str1.substring(0, i);//包前不包后
				//验证任取的长度为2的gcdString是否在str1和str2中不断重复
				if (ifRepeat(str1, gcdString) && ifRepeat(str2, gcdString)) {
					return gcdString;
				}
			}
		}
		return "";
    }
	
	public static void main(String[] args) {
		String str1 = "ABABAB";
		String str2 = "ABAB";
		String gcd = gcdOfStrings(str1, str2);
		System.out.println(gcd);
	}

}

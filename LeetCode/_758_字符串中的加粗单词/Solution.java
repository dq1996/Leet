package LeetCode._758_字符串中的加粗单词;

/*
 * 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。
 * 所有在标签 <b> 和 </b> 中的字母都会加粗。
 * 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
 * 
 * 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。
 * 注意返回 "a<b>a<b>b</b>c</b>d" 会使用更多的标签，因此是错误的。
 * 
 * 注：
 * words 长度的范围为 [0, 50]。
 * words[i] 长度的范围为 [1, 10]。
 * S 长度的范围为 [0, 500]。
 * 所有 words[i] 和 S 中的字符都为小写字母。
 */

/*
 * 思路：
 * 1、使用一个与字符串S相同大小的布尔数组来存储每个字符是否需要加粗；
 * 2、使用StringBuffer拼接加粗标签和字符。
 * 
 * 时间复杂度O(n)、空间复杂度O(n)
 */
public class Solution {
	
	private static String setBoldLabel(boolean[] isBold, String S) {
		StringBuffer sb = new StringBuffer();
		//考虑首尾情况
		if (isBold[0]) {
			sb.append("<b>");
		}
		for (int i = 0; i < S.length(); i ++) {
			sb.append(S.charAt(i));
			if (i == S.length() - 1) {
				if (isBold[i]) {
					sb.append("</b>");
				}
				break;//避免接下来数组越界
			}
			if (isBold[i] && ! isBold[i + 1]) {
				sb.append("</b>");
			}
			if (!isBold[i] && isBold[i + 1]) {
				sb.append("<b>");
			}
		}
		return sb.toString();
	}
	
	public static String boldWords(String[] words, String S) {
		boolean[] isBold = new boolean[S.length()];
		isBold(words, S, isBold);
		S = setBoldLabel(isBold, S);
		return S;
    }

	private static void isBold(String[] words, String S, boolean[] isBold) {
		for (String word : words) {
			//该函数返回从o开始匹配上的最小字符
			int startIndex = S.indexOf(word, 0);
			//如果S中存在关键词
			while (startIndex != -1) {
				for (int i = startIndex; i < startIndex + word.length(); i ++) {
					isBold[i] = true;
				}
				startIndex = S.indexOf(word, startIndex + 1);//字符串中可能不止匹配一次该关键字
			}
		}
	}
	
	public static void main(String[] args) {
		String[] keywords = {"ab", "bc"};
		String str = "aabcd";
		str = boldWords(keywords, str);
		System.out.println(str);
	}

}

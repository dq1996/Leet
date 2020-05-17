package LeetCode._1360_日期之间隔几天;

/*
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * 
 * 示例 1：
 * 输入：
 * date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：
 * 1
 * 
 * 示例 2：
 * 输入：
 * date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：
 * 15
 * 
 * 提示：
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 */

/*
 * 思路：
 * 约定以1971.1.1为起点，计算出两者距离起点的天数，取差的绝对值
 * 1、先算出当年当月的天数；
 * 2、算出当年前几个月所有的天数；
 * 3、算出这些年来的天数。
 * 
 * 时间复杂度O(1)、空间复杂度O(1)
 */
public class Solution1_优化转化法 {
	
	//闰年的判定条件
	private static boolean isLeapYear(int year) {
		if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}
	
	//计算某个日期距离1971.1.1的天数
	private static int convertToDaysFrom1971(String date) {
		String[] dateConvert = date.split("-");
		int year = Integer.parseInt(dateConvert[0]);
		int month = Integer.parseInt(dateConvert[1]);
		int day = Integer.parseInt(dateConvert[2]);
		//算清当年1.1后的天数
		int days = day - 1;
		int[] month_length = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		while (month > 1) {
			month --;
			days += month_length[month];
			if (month == 2 && isLeapYear(year)) {
				days ++;
			}
		}
		days += (year - 1971) * 365;
		days += (year - 1) / 4 - 1971 / 4;//由于除法取整特性，不可使用(year-1971)/4
		//能被4整除的年份里包含100的倍数年份，虽然从1971开始的2000是闰年
		days -= (year - 1) / 100 - 1971 / 100;
		//能被100整除的年份里包含400的倍数年份，如2000是闰年
		days += (year - 1) / 400 - 1971 / 400;
		return days;
	}
	public static int daysBetweenDates(String date1, String date2) {
		//约定以1971.1.1为起点，计算出两者距离起点的天数，取差的绝对值
		int days = Math.abs(convertToDaysFrom1971(date1) - convertToDaysFrom1971(date2));
		return days;
    }
	
	public static void main(String[] args) {
		String date1 = "1971-06-29";
		String date2 = "2010-09-23";
		int days = daysBetweenDates(date1, date2);
		System.out.println(days);
	}

}

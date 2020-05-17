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
 * 
 * 时间复杂度O(n)、空间复杂度O(1)
 */
public class Solution0_暴力法 {
	
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
		int days = 0;
		int[] month_length = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		//约定起始时间点1971.1.1
		while (year != 1971 || month != 1 || day != 1) {
			//走一次循环天数+1
			days ++;
			//先从日减起
			day --;
			//若日减到0，减月
			if (day == 0) {
				month --;
				//若月减到0，减年
				if (month == 0) {
					year --;
				}
			}
			//当日减到0时，根据当前年月重置日
			if (day == 0) {
				day = month_length[month];
				if (month == 2 && isLeapYear(year)) {
					day ++;
				}
			}
			//当月减到0时，重置月
			if (month == 0) {
				month = 12;
			}
		}
		return days;
	}
	public static int daysBetweenDates(String date1, String date2) {
		//约定以1971.1.1为起点，计算出两者距离起点的天数，取差的绝对值
		int days = Math.abs(convertToDaysFrom1971(date1) - convertToDaysFrom1971(date2));
		return days;
    }
	
	public static void main(String[] args) {
		String date1 = "2020-01-15";
		String date2 = "2019-12-31";
		int days = daysBetweenDates(date1, date2);
		System.out.println(days);
	}

}

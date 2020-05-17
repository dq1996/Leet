package LeetCode._1179_重新格式化部门表;

/*
 * SQL架构
 * 
 * 部门表 Department：
 * +-----------------+-----------+
 * | Column Name	| Type		|
 * +-----------------+-----------+
 * | id						| int			|
 * | revenue			| int			|
 * | month				| varchar	|
 * +-----------------+-----------+
 * (id, month) 是表的联合主键。
 * 
 * 这个表格有关于每个部门每月收入的信息。
 * 月份（month）可以取下列值 ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]。
 * 编写一个 SQL 查询来重新格式化表，使得新的表中有一个部门 id 列和一些对应 每个月 的收入（revenue）列。
 * 
 * 查询结果格式如下面的示例所示：
 * Department 表：
 * +----+------------+-------+
 * | id   | revenue	| month	|
 * +----+------------+-------+
 * | 1    | 8000			| Jan		|
 * | 2    | 9000			| Jan		|
 * | 3    | 10000		| Feb		|
 * | 1    | 7000			| Feb		|
 * | 1    | 6000			| Mar		|
 * +----+------------+-------+
 * 
 * 查询得到的结果表：
 * +----+---------------+-----------------+------------------+--+----------------+
 * | id   | Jan_Revenue	| Feb_Revenue	| Mar_Revenue	| ... | Dec_Revenue	|
 * +----+---------------+-----------------+------------------+--+----------------+
 * | 1    | 8000				| 7000				| 6000				| ... | nul					|
 * | 2    | 9000				| null					| null					| ... | null					|
 * | 3    | null				| 10000				| null					| ... | null					|
 * +----+---------------+-----------------+------------------+--+-----------------+
 * 
 * 注意，结果表有 13 列 (1个部门 id 列 + 12个月份的收入列)。
 */

/*
 * 思路：
 * 1、使用id进行分组；
 * 2、casewhen语句将列拆成行；
 * 3、使用sum根据id合并行；
 * 4、对month使用转义。
 */
public class Solution {

	public static void main(String[] args) {
		//SQL
//		select id,
//		sum(case `month` when 'Jan' then revenue end) Jan_Revenue,
//		sum(case `month` when 'Feb' then revenue end) Feb_Revenue,
//		sum(case `month` when 'Mar' then revenue end) Mar_Revenue,
//		sum(case `month` when 'Apr' then revenue end) Apr_Revenue,
//		sum(case `month` when 'May' then revenue end) May_Revenue,
//		sum(case `month`when 'Jun' then revenue end) Jun_Revenue,
//		sum(case `month` when 'Jul' then revenue end) Jul_Revenue,
//		sum(case `month` when 'Aug' then revenue end) Aug_Revenue,
//		sum(case `month` when 'Sep' then revenue end) Sep_Revenue,
//		sum(case `month` when 'Oct' then revenue end) Oct_Revenue,
//		sum(case `month` when 'Nov' then revenue end) Nov_Revenue,
//		sum(case `month` when 'Dec' then revenue end) Dec_Revenue
//		from department
//		group by id;
	}

}

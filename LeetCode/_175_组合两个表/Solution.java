package LeetCode._175_组合两个表;

/*
 * SQL架构
 * 
 * 表1: Person
 * +--------------+-----------+
 * | 列名				| 类型			|
 * +--------------+-----------+
 * | PersonId		| int			|
 * | FirstName		| varchar	|
 * | LastName		| varchar	|
 * +--------------+-----------+
 * PersonId 是上表主键
 * 
 * 表2: Address
 * +--------------+-----------+
 * | 列名				| 类型			|
 * +--------------+-----------+
 * | AddressId	| int			|
 * | PersonId		| int			|
 * | City				| varchar	|
 * | State			| varchar	|
 * +--------------+-----------+
 * AddressId 是上表主键
 * 
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 * FirstName, LastName, City, State
 */

/*
 * 思路：
 * 使用左连接来避免没有地址的情况
 * 如果没有某个人的地址信息，使用 where 子句过滤记录将失败，因为它不会显示姓名信息。
 */
public class Solution {

	public static void main(String[] args) {
		//SQL
		/*
		 * select FirstName, LastName, City, State 
		 * from Person left join Address on
		 * Person.PersonId = Address.PersonId;
		 */
	}

}

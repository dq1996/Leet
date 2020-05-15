package LeetCode._1114_按序打印;

/*
 * 我们提供了一个类：
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * 
 * 示例 1:
 * 输入: 
 * [1,2,3]
 * 
 * 输出: 
 * "onetwothree"
 * 
 * 解释: 
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 
 * 示例 2:
 * 输入: 
 * [1,3,2]
 * 
 * 输出: 
 * "onetwothree"
 * 
 * 解释: 
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 */

/*
 * 思路：
 * 使用firstJobDone来控制two始终在one后
 * 使用secondJobDone来控制third始终在two后
 */
public class Foo {
	
	private int firstJobDone = 0;
	private int secondJobDone = 0;
	
	public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone ++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone != 1) {
        	
        }
        printSecond.run();
        secondJobDone ++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone != 1) {
        	
        }
        printThird.run();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

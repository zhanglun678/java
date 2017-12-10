/**
 *@date 2017年12月10日下午1:34:22
 */
package com.zhanglun.test1;

/**
 * @author zhanglun
 * @todo 初始化顺序
 * @desc 在类的内部，变量定义的先后顺序决定了初始化的顺序。 即使变量定义散布于方法定义之间，它们仍旧会在任何方法（ 包括构造器）之前得到初始化
 */
public class InitTest {
	public static void main(String[] args) {
		House h = new House();
		h.f();
	}
}

class Window {
	public Window(int marker) {
		System.out.println("window(" + marker + ");");
	}
}

class House {
	Window w = new Window(1); // 第1步

	public House() {
		System.out.println("House()"); // 第4步
		//因为会执行定义变量的代码
		w3 = new Window(3); // 第5步
	}

	Window w2 = new Window(2); // 第2步

	void f() {
		System.out.println("f()"); // 第6步
	}

	Window w3 = new Window(3); // 第3步
}
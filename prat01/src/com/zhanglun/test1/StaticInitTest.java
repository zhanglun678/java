package com.zhanglun.test1;

/**
 * @author zhanglun
 * @todo
 * @desc 静态数据初始化
 */
class Bowl {
	Bowl(int marker) {
		System.out.println("Bowl(" + marker + ");");
	}

	void f1(int marker) {
		System.out.println("f1(" + marker + ");");
	}
}

class Table {
	static Bowl bowl1 = new Bowl(1); // 静态

	Table() {
		System.out.println("Table()");
		bowl2.f1(1);
	}

	void f2(int marker) {
		System.out.println("f2(" + marker + ");");
	}

	static Bowl bowl2 = new Bowl(2); // 静态

}

class Cupboard {
	Bowl bowl3 = new Bowl(3); // ***还是会走这一步
	static Bowl bowl4 = new Bowl(4);

	Cupboard() {
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}

	void f3(int marker) {
		System.out.println("f3(" + marker + ");");
	}

	static Bowl bowl5 = new Bowl(5);
}

/*
 * Bowl(1); Bowl(2); Table() f1(1); Bowl(4); Bowl(5); Bowl(3); Cupboard() f1(2);
 * ----------------------------上面是静态代码部分
 * 
 * create new Cupboard() in main Bowl(3); Cupboard() f1(2); create new
 * Cupboard() in main Bowl(3); Cupboard() f1(2); f2(1); f3(1);
 * 
 */
public class StaticInitTest {
	public static void main(String[] args) {
		System.out.println("create new Cupboard() in main");
		new Cupboard();
		System.out.println("create new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
 
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();

}

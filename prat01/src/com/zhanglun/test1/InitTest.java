/**
 *@date 2017��12��10������1:34:22
 */
package com.zhanglun.test1;

/**
 * @author zhanglun
 * @todo ��ʼ��˳��
 * @desc ������ڲ�������������Ⱥ�˳������˳�ʼ����˳�� ��ʹ��������ɢ���ڷ�������֮�䣬�����Ծɻ����κη����� ������������֮ǰ�õ���ʼ��
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
	Window w = new Window(1); // ��1��

	public House() {
		System.out.println("House()"); // ��4��
		//��Ϊ��ִ�ж�������Ĵ���
		w3 = new Window(3); // ��5��
	}

	Window w2 = new Window(2); // ��2��

	void f() {
		System.out.println("f()"); // ��6��
	}

	Window w3 = new Window(3); // ��3��
}
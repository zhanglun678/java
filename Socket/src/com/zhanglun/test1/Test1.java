package com.zhanglun.test1;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * 
 * @author zhanglun
 * @todo
 * @desc InetAddress�ೣ�÷���
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		// ��ȡ������InetAddressʵ��
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr);
		// ip ��ַ
		String host = addr.getHostAddress();
		System.out.println(host);
		// �������
		String name = addr.getHostName();
		System.out.println(name);
		// ���ֽ�������ʽ����ip
		byte[] b = addr.getAddress();
		// Arrays.toString() �ֽ�����תΪstring
		System.out.println(Arrays.toString(b));

		System.out.println("==========================");
		InetAddress addr2 = InetAddress.getByName("192.168.244.1");
		System.out.println("�������" + addr2.getHostName());
		System.out.println("ip ��ַ" + addr2.getHostAddress());
	}
}

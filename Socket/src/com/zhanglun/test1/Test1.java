package com.zhanglun.test1;

import java.net.InetAddress;
import java.util.Arrays;

/**
 * 
 * @author zhanglun
 * @todo
 * @desc InetAddress类常用方法
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		// 获取本机的InetAddress实例
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr);
		// ip 地址
		String host = addr.getHostAddress();
		System.out.println(host);
		// 计算机名
		String name = addr.getHostName();
		System.out.println(name);
		// 以字节数组形式返回ip
		byte[] b = addr.getAddress();
		// Arrays.toString() 字节数组转为string
		System.out.println(Arrays.toString(b));

		System.out.println("==========================");
		InetAddress addr2 = InetAddress.getByName("192.168.244.11");
		System.out.println("计算机名" + addr2.getHostName());
		System.out.println("ip 地址" + addr2.getHostAddress());
	}
}

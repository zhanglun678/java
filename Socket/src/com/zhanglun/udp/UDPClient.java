package com.zhanglun.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author zhanglun
 * @todo 客户端的实现
 * @desc
 */
public class UDPClient {
	public static void main(String[] args) throws Exception {
		/**
		 * 向服务器发送数据
		 */
		// 定义服务器的地址,端口号，相应的数据
		InetAddress addrs = InetAddress.getByName("localhost");
		int port = 8888;
		byte[] data = "客户发送的信息： 用户名 ：admin 密码：123 ".getBytes();
		// 创建数据报。包含发送的信息
		DatagramPacket packet = new DatagramPacket(data, data.length, addrs, port);
		// 创建 datagramsocket对象
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		// socket.close();

		/**
		 * 接收响应数据
		 */
		// 创建数据报，接收服务器响应的数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// 接收数据
		socket.receive(packet2);
		// 读取数据
		String reply = new String(data2, 0, data2.length);
		System.out.println("服务器响应的数据为：" + reply);
		socket.close();
	}
}

package com.zhanglun.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author zhanglun
 * @todo 服务端，基于UDP的用户登录
 * @desc 服务端
 */
public class UDPServer {
	public static void main(String[] args) throws Exception {
		/**
		 * 接收数据
		 */
		// 创建服务器端 DatagramSocket 并指定端口
		DatagramSocket socket = new DatagramSocket(8888);
		// 创建数据报，用于接收客户发送的数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("服务器端已启动，等待连接：");
		// 接收客户端的数据
		socket.receive(packet);// 此方法在接收数据之前会一直阻塞
		// 读取该数据
		String info = new String(data, 0, packet.getLength());
		System.out.println("服务器接收的数据为：" + info);
		/**
		 * 响应数据
		 */
		// 向客户端发送数据
		// 获取客户端的地址
		InetAddress addrs = packet.getAddress();
		// 获取端口号
		int port = packet.getPort();
		byte[] data2 = "欢迎您！".getBytes();
		// 创建数据报
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, addrs, port);
		// 响应客户端
		socket.send(packet2);
		// 关闭资源
		socket.close();

	}
}

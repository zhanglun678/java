package com.zhanglun.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author zhanglun
 * @todo �ͻ��˵�ʵ��
 * @desc
 */
public class UDPClient {
	public static void main(String[] args) throws Exception {
		/**
		 * ���������������
		 */
		// ����������ĵ�ַ,�˿ںţ���Ӧ������
		InetAddress addrs = InetAddress.getByName("localhost");
		int port = 8888;
		byte[] data = "�ͻ����͵���Ϣ�� �û��� ��admin ���룺123 ".getBytes();
		// �������ݱ����������͵���Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, addrs, port);
		// ���� datagramsocket����
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		// socket.close();

		/**
		 * ������Ӧ����
		 */
		// �������ݱ������շ�������Ӧ������
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		// ��������
		socket.receive(packet2);
		// ��ȡ����
		String reply = new String(data2, 0, data2.length);
		System.out.println("��������Ӧ������Ϊ��" + reply);
		socket.close();
	}
}

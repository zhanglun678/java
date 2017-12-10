package com.zhanglun.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author zhanglun
 * @todo ����ˣ�����UDP���û���¼
 * @desc �����
 */
public class UDPServer {
	public static void main(String[] args) throws Exception {
		/**
		 * ��������
		 */
		// ������������ DatagramSocket ��ָ���˿�
		DatagramSocket socket = new DatagramSocket(8888);
		// �������ݱ������ڽ��տͻ����͵�����
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("�����������������ȴ����ӣ�");
		// ���տͻ��˵�����
		socket.receive(packet);// �˷����ڽ�������֮ǰ��һֱ����
		// ��ȡ������
		String info = new String(data, 0, packet.getLength());
		System.out.println("���������յ�����Ϊ��" + info);
		/**
		 * ��Ӧ����
		 */
		// ��ͻ��˷�������
		// ��ȡ�ͻ��˵ĵ�ַ
		InetAddress addrs = packet.getAddress();
		// ��ȡ�˿ں�
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		// �������ݱ�
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, addrs, port);
		// ��Ӧ�ͻ���
		socket.send(packet2);
		// �ر���Դ
		socket.close();

	}
}

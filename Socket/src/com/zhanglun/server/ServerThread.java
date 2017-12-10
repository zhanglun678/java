package com.zhanglun.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author zhanglun
 * @todo �������̴߳�����
 * @desc
 */
public class ServerThread extends Thread {
	Socket socket = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	/**
	 * ��дrun����
	 */
	public void run() {
		InputStream is = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// ��ȡ������������ȡ�ͻ��˷��͵���Ϣ
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			// ѭ����ȡ
			while ((info = br.readLine()) != null) {
				System.out.println("�ҵķ��������ͻ���˵��" + info);
			}
			socket.shutdownInput();
			// ��ȡ���������Ӧ�ͻ���
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("���ӳɹ� ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر��������
			if (pw != null) {

				pw.flush();
			}
			if (pw != null) {
				pw.close();
			}
			try {
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

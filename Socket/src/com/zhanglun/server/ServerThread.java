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
 * @todo 服务器线程处理类
 * @desc
 */
public class ServerThread extends Thread {
	Socket socket = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	/**
	 * 重写run方法
	 */
	public void run() {
		InputStream is = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// 获取输入流用来读取客户端发送的信息
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			// 循环读取
			while ((info = br.readLine()) != null) {
				System.out.println("我的服务器，客户端说：" + info);
			}
			socket.shutdownInput();
			// 获取输出流，响应客户端
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("连接成功 ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭相关连接
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

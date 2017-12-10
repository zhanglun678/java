package com.zhanglun.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author zhanglun
 * @todo 连接服务器
 * @desc 客户端
 */
public class Client {
	public static void main(String[] args) throws Exception {
		// 1. 创建客户端 socket.指定服务器地址与端口
		Socket socket = new Socket("localhost", 8888);
		// 获取输出流，向服务端发送信息
		OutputStream os = socket.getOutputStream();
		// 将输出流包装为打印流
		PrintWriter pw = new PrintWriter(os);
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要发送的信息：");
		pw.write(sc.next());
		pw.flush();
		socket.shutdownOutput();// 关闭输出流
		// 获取输入流，读取服务器的响应信息
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while ((info = br.readLine()) != null) {
			System.out.println("客户端 ：： 服务器说：" + info);
		}
		br.close();
		is.close();
		pw.close();
		sc.close();
		socket.close();

	}
}

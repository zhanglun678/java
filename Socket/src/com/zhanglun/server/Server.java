package com.zhanglun.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author zhanglun
 * @todo 服务器端
 * @desc 服务端 ，基于TCP协议的socket通信，实现用户登录功能
 */
public class Server {
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		ServerSocket serverSocket = null;
		// 1.创建一个服务端 socket,即serverSocket 指定绑定端口，并紧监听
		serverSocket = new ServerSocket(8888);
		System.out.println("服务器开始等待客户端连接 ..............");
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			ServerThread st = new ServerThread(socket);
			count++;
			System.out.println("客户端总数为：" + count);
			System.out.println("当前客户端的IP地址为：" + socket.getLocalAddress());
			;
			st.start();
		}
	}
}

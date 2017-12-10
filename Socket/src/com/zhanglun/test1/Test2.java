package com.zhanglun.test1;

import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author zhanglun
 * @todo
 * @desc URL
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost/cookie/cookie.php");
		URL u = new URL(url, "cookie.php?uname=lisi");
		System.out.println("协议：" + u.getProtocol());
		System.out.println("主机:" + u.getHost());
		System.out.println("端口：" + u.getPort());
		URLConnection conn = u.openConnection();
		System.out.println(conn.getDate() + "\t\t" + conn);
		System.out.println(u.getFile());// 返回文件路径
		System.out.println(u.getRef()); // 锚点
		System.out.println(u.getQuery()); // ? 后的数据
		
		
	}
}

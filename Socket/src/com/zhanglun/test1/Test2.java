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
		System.out.println("Э�飺" + u.getProtocol());
		System.out.println("����:" + u.getHost());
		System.out.println("�˿ڣ�" + u.getPort());
		URLConnection conn = u.openConnection();
		System.out.println(conn.getDate() + "\t\t" + conn);
		System.out.println(u.getFile());// �����ļ�·��
		System.out.println(u.getRef()); // ê��
		System.out.println(u.getQuery()); // ? �������
		
		
	}
}

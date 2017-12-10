package com.zhanglun.test1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author zhanglun
 * @todo
 * @desc 获取网络上的数据
 */
public class URLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost/cookie/cookie.php?uname=张伦");
		InputStream is = url.openStream();
		// 将字节输入流转为字符输入流
		InputStreamReader isr = new InputStreamReader(is,"GBK");
		// 添加缓冲流，提高效率
		BufferedReader br = new BufferedReader(isr);
		String data = br.readLine();
		while (data != null) {
			System.out.println(data);
			// 读取下一行
			data = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}
}

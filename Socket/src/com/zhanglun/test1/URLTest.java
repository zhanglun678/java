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
 * @desc ��ȡ�����ϵ�����
 */
public class URLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost/cookie/cookie.php?uname=����");
		InputStream is = url.openStream();
		// ���ֽ�������תΪ�ַ�������
		InputStreamReader isr = new InputStreamReader(is,"GBK");
		// ��ӻ����������Ч��
		BufferedReader br = new BufferedReader(isr);
		String data = br.readLine();
		while (data != null) {
			System.out.println(data);
			// ��ȡ��һ��
			data = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}
}

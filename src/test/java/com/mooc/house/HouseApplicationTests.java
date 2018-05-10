package com.mooc.house;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests { //该单元测试是需要启动类的加载

	//第三步后就可以进行测试

	/*测试自定义启动依赖*/
	@Autowired
	private HttpClient httpClient;  //因为已经创建了自动配置，所以这个bean已经存在了
	@Test
	public void contextLoads() throws ParseException, ClientProtocolException,IOException{
		//像百度发送一个请求并打印
		System.out.println(EntityUtils.toString(httpClient.execute(new HttpGet("http://www.baidu.com")).getEntity()).toString());
	}
	@Test
	public void testHttpClient() throws ParseException, ClientProtocolException,IOException{
		//像百度发送一个请求并打印
		System.out.println(EntityUtils.toString(httpClient.execute(new HttpGet("http://www.baidu.com")).getEntity()));
	}



}

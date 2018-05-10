package com.mooc.house.autoconfig;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**  autoconfig 包下是实现自定义启动依赖
 * 创建自定义启步依赖类
 */
//第二步

@Configuration //首先将该类声明为java config
@ConditionalOnClass({HttpClient.class}) //添加条件注解，就是在这个HttpClient类存在的时候才会加载这个类
@EnableConfigurationProperties(HttpClientProperties.class)//把创建好的HttpClientProperties引进过来 通过作为bean的方式
public class HttpClientAutoConfiguration {

	private final HttpClientProperties properties;
	//通过构造器注入进来
	public HttpClientAutoConfiguration(HttpClientProperties properties){
		this.properties = properties;
	}
	
	/**
	 * httpclient bean 的定义  创建bean实例
	 * @return
	 */
	@Bean//创建实例
	@ConditionalOnMissingBean(HttpClient.class)//用户未定义HttpClient对象情况下。才会创建加载这个bean，进行创建
	public HttpClient httpClient(){
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(properties.getConnectTimeOut())//这设置链接时间，超时时间
				.setSocketTimeout(properties.getSocketTimeOut()).build();//构建requestConfig
		HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setUserAgent(properties.getAgent())
				.setMaxConnPerRoute(properties.getMaxConnPerRoute()).setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();
		//new NoConnectionReuseStrategy()防止进行重试
		return client;
	}
}

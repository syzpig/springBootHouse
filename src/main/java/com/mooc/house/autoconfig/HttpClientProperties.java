package com.mooc.house.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 *创建Properties文件 提供给用户进行配置的，跟druid spring 等等一样
 * spring.httpclient根据前缀这个进行下面属性配置在配置文件中
 * 以下是默认值，
 */
//第三步
@ConfigurationProperties(prefix="spring.httpclient")
public class HttpClientProperties {
	
	private Integer connectTimeOut = 1000;//默认超时时间
	
	private Integer socketTimeOut = 10000;//默认超时时间

	private String agent = "agent";
	private Integer maxConnPerRoute = 10; //每个ip最大连接数
	private Integer maxConnTotaol   = 50;//总连接数
	public Integer getConnectTimeOut() {
		return connectTimeOut;
	}
	public void setConnectTimeOut(Integer connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}
	public Integer getSocketTimeOut() {
		return socketTimeOut;
	}
	public void setSocketTimeOut(Integer socketTimeOut) {
		this.socketTimeOut = socketTimeOut;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public Integer getMaxConnPerRoute() {
		return maxConnPerRoute;
	}
	public void setMaxConnPerRoute(Integer maxConnPerRoute) {
		this.maxConnPerRoute = maxConnPerRoute;
	}
	public Integer getMaxConnTotaol() {
		return maxConnTotaol;
	}
	public void setMaxConnTotaol(Integer maxConnTotaol) {
		this.maxConnTotaol = maxConnTotaol;
	}
	
	
	
}

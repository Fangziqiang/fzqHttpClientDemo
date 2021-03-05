package com.dashanedu.demo;

//参考：
//https://www.jqhtml.com/55522.html
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SimpleGetTest {
    public static void main(String[] args) throws ClientProtocolException, IOException{
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建请求方法的实例， 并指定请求url
        HttpGet httpget=new HttpGet("http://www.baidu.com");
        //获取http响应状态码
        CloseableHttpResponse response=httpClient.execute(httpget);
        HttpEntity entity=response.getEntity();
        //接收响应头
        String content=EntityUtils.toString(entity, "utf-8");
        System.out.println(httpget.getURI());
        System.out.println(content);
        httpClient.close();
    }
}
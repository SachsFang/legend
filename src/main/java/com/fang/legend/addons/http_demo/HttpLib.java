package com.fang.legend.addons.http_demo;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by SachsFang on 2021/5/22 17:29
 */
public class HttpLib {
    public static RequestConfig requestConfig = null;

    static {
        try {
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(3000)
                    .setConnectTimeout(3000)
                    .setSocketTimeout(3000)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CloseableHttpClient connect() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(SSLConnectionSocketFactory.getSocketFactory())
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .useSystemProperties()
                .build();
        return httpClient;
    }

    public static String get(String url) {
        CloseableHttpClient httpClient = connect();
        CloseableHttpClient reponseBody = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(builder.build());
            reponseBody = (CloseableHttpClient) httpClient.execute(httpGet);
            return reponseBody.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.example.swagger;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ClientException;
import com.example.swagger.apigateway.ApiGateway;
import com.example.swagger.apigateway.impl.ApiGatewayImpl;
import com.example.swagger.apigateway.pojo.SwaggerBackendInfoBase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = SwaggerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerApplicationTests {

    /**
     * swagger 服务接口
     */
    private String swaggerApiDocUrl = "http://localhost:8080/v2/api-docs";

    @Test
    public void cicdIntegration() {
        ApiGateway apiGateway = new ApiGatewayImpl();
        try {
            // 创建API分组, 用于存储通过swagger导入的api
            String groupId = apiGateway.createGroup("CiCdGroup1");

            // 配置API网关所需的服务后端信息
            SwaggerBackendInfoBase info = new SwaggerBackendInfoBase();
            info.setType("HTTP");
            info.setAddress("http://www.aliyun.com");

            // 将API的后端服务后端信息
            Map<String, String> globalCondition  = new HashMap<>();
            globalCondition.put("x-aliyun-apigateway-backend", JSON.toJSONString(info));

            // 通过api网关导入swagger创建API
            apiGateway.importSwagger(groupId, getSwaggerData(), JSON.toJSONString(globalCondition));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     *  通过服务接口获取 swagger doc.
     */
    private String getSwaggerData(){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(swaggerApiDocUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();
        }

        return result;
    }

}

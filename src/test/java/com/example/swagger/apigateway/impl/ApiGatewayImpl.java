package com.example.swagger.apigateway.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudapi.model.v20160714.CreateApiGroupRequest;
import com.aliyuncs.cloudapi.model.v20160714.CreateApiGroupResponse;
import com.aliyuncs.cloudapi.model.v20160714.ImportSwaggerRequest;
import com.aliyuncs.cloudapi.model.v20160714.ImportSwaggerResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.example.swagger.apigateway.ApiGateway;

/**
 * @author lenny
 * @since 2020/4/24 5:18 PM
 */
public class ApiGatewayImpl implements ApiGateway {

    private IAcsClient client;

    public ApiGatewayImpl() {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "<<您的阿里云 key id>>",
                "<<您的阿里云 key secret>>");

        client = new DefaultAcsClient(profile);
    }

    @Override
    public String createGroup(String groupName) throws ClientException {
        CreateApiGroupRequest request = new CreateApiGroupRequest();
        request.setGroupName(groupName);
        CreateApiGroupResponse response = client.getAcsResponse(request);
        System.out.println(">> GroupID << === >> " + response.getGroupId() + " <<");
        return response.getGroupId();
    }

    @Override
    public void importSwagger(String groupId, String swaggerData, String globalCondition) throws ClientException {
        ImportSwaggerRequest request = new ImportSwaggerRequest();
        request.setGroupId(groupId);
        request.setDataFormat("json");
        request.setData(swaggerData);
        request.setGlobalCondition(globalCondition);
        request.setbOverwrite(true);
        ImportSwaggerResponse response = client.getAcsResponse(request);
        System.out.println(JSON.toJSONString(response));
    }
}

package com.example.swagger.apigateway;

import com.aliyuncs.exceptions.ClientException;

/**
 * @author lenny
 * @since 2020/4/24 2:22 PM
 */
public interface ApiGateway {

    /**
     *
     * 导入swagger
     *
     * @param groupId                   分组id
     * @param swaggerData               swagger数据
     * @param globalCondition           全局配置
     * @throws ClientException
     */
    void importSwagger(String groupId, String swaggerData, String globalCondition) throws ClientException;


    /**
     *
     * 创建API分组并返回GroupId
     *
     * @param groupName 分组名称
     * @return 分组id
     * @throws ClientException
     */
    String createGroup(String groupName) throws ClientException;
}

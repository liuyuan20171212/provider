/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dubbo 提供者 API 配置
 * @author ityuan
 * @version $Id: DubboConfig, v 0.1 2019-02-27 13:58 ityuan Exp $
 */
@Configuration
@DubboComponentScan(basePackages = "com.ityuan.dubbo.service.impl")
public class ProviderDubboConfig {

    @Value("${dubbo.application.name}")
    private String  name;

    @Value("${dubbo.registry.address}")
    private String  address;

    @Value("${dubbo.registry.protocol}")
    private String  protocol;

    @Value("${dubbo.protocol.name}")
    private String  protocolName;

    @Value("${dubbo.protocol.port}")
    private Integer port;

    /**
     * 当前应用配置
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName(name);
        return application;
    }

    /**
     * 连接注册中心配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(address);
        registry.setProtocol(protocol);
        return registry;
    }

    /**
     * 服务提供者协议配置
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName(protocolName);
        protocol.setPort(port);
        protocol.setThreads(200);
        return protocol;
    }

    /**
     * 服务提供者暴露服务配置
     * @return
     */
    @Bean
    public ProviderConfig providerConfig(ApplicationConfig applicationConfig,
                                         RegistryConfig registryConfig,
                                         ProtocolConfig protocolConfig) {
        ProviderConfig serviceConfig = new ProviderConfig();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        /**
         * 延迟暴露，延迟到Spring 初始化完成后，在暴露服务
         */
        serviceConfig.setDelay(-1);
        return serviceConfig;
    }

}

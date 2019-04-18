/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 一库 数据源配置
 * @author ityuan
 * @version $Id: DatasourceConfig, v 0.1 2019-03-01 13:24 ityuan Exp $
 */
@Configuration
@MapperScan(basePackages = "com.ityuan.dubbo.dao01", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class Datasource1Config {
    /**
     * 配置test1数据库
     * @return
     */
    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.y")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:com/ityuan/dubbo/mybatis/mapper/01/*.xml"));
        return bean.getObject();
    }

    /**
     *test1 事物管理器
     */
    @Bean(name = "test1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置sqlSession模板
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

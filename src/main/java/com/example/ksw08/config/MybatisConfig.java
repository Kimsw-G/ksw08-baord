package com.example.ksw08.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
// @Mapper interface tmzos rudfh
@MapperScan(basePackages = "com.example.ksw08.dao")
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        System.out.println();

        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.example.ksw08.vo");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        return  sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

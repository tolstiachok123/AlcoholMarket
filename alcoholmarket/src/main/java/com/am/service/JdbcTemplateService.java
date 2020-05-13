package com.am.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcTemplateService {

    private final static String driverClassName = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/AlcoholMarket?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    private final static String user = "root";
    private final static String password = "9109";

    public static JdbcTemplate templateCreation() {
        DataSource dataSource = getDataSource();
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    public static DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}

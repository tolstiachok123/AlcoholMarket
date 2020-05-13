package com.am.configuration;

import com.am.entity.AlcoholDrink;
import com.am.repository.AlcoholDrinkRepository;
import com.am.service.JdbcTemplateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/views/");
        return freeMarkerConfigurer;
    }

    @Bean
    @Scope("prototype")
    public AlcoholDrink alcoholDrink(){
        return new AlcoholDrink();
    }

    @Bean
    public AlcoholDrinkRepository alcoholDrinkRepository(){
        return new AlcoholDrinkRepository();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplateService().templateCreation();
    }
}

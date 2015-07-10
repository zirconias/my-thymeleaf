package com.zirconias.thyspring.config;

import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by xirc on 03/07/2015.
 */

@Configuration
public class ThymeleafConfiguration {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ThymeleafProperties thymeleafProperties;

    @Value("${spring.thymeleaf.templates_root:}")//src/main/resources/templates/
    private String templatesRoot;

    @Autowired
    private Environment env;

    @Bean
    public ITemplateResolver defaultTemplateResolver() {
        TemplateResolver resolver = new FileTemplateResolver();
        resolver.setSuffix(thymeleafProperties.getSuffix());
        resolver.setPrefix(templatesRoot);
        resolver.setTemplateMode(thymeleafProperties.getMode());
        resolver.setCharacterEncoding(thymeleafProperties.getEncoding());
        if (env.getProperty("spring.profiles.active").equals("dev")) {
            resolver.setCacheable(false);
        }
        return resolver;
    }


    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(defaultTemplateResolver());
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new DataTablesDialect());
        templateEngine.addDialect(new DataAttributeDialect());
        return templateEngine;
    }






}

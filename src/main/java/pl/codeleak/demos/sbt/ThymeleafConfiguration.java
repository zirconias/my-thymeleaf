package pl.codeleak.demos.sbt;

import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.Locale;

/**
 * Created by xirc on 03/07/2015.
 */

@Configuration
public class ThymeleafConfiguration {
    @Autowired
    private ThymeleafProperties properties;

    @Value("${spring.thymeleaf.templates_root:}")
    private String templatesRoot;

    @Autowired
    private Environment env;

    @Bean
    public ITemplateResolver defaultTemplateResolver() {
        TemplateResolver resolver = new FileTemplateResolver();
        resolver.setSuffix(properties.getSuffix());
        resolver.setPrefix(templatesRoot);
        resolver.setTemplateMode(properties.getMode());
        resolver.setCharacterEncoding(properties.getEncoding());
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

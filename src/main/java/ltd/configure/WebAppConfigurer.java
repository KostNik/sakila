package ltd.configure;

import lombok.extern.slf4j.Slf4j;
import ltd.filters.CORSFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.util.UrlPathHelper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableWebMvc
@Configuration
@ComponentScan("ltd")
@PropertySource({"classpath:application.properties", "classpath:message.properties"})
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/WEB-INF/resources/",
            "classpath:/META-INF/web-resources/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**", "/img/**", "/pdf/**", "/resources/js/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    //Access-Control-Allow-Origin
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedHeaders("Access-Control-Allow-Origin").allowedMethods("GET", "POST").allowedOrigins("*");
//        log.info("CORS REGISTRY: {}", registry);
//    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    // for @MatrixVariable supporting
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<View> views = new ArrayList<>();
        views.add(jsonView());
        resolver.setDefaultViews(views);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        log.info("InternalResourceViewResolver was configured");
        System.out.println("111!!!");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setCache(true);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }


//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freemarker.template.Configuration configuration = new freemarker.template.Configuration();
//        freeMarkerConfigurer.setTemplateLoaderPaths("/WEB-INF/freemarker/", "/freemarker/", "");
//     freeMarkerConfigurer.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
//        freeMarkerConfigurer.setConfiguration(configuration);
//        return freeMarkerConfigurer;
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        resolver.setContentType("text/html; charset=UTF-8");
//        return resolver;
//    }

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
//    }

}

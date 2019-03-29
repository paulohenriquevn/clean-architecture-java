package application.config;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    protected ResourceProperties resourceProperties = new ResourceProperties();

    /**
     * Habilita o CORS = *
     * Retirar no ambiente de produção
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        final String[] staticLocations = resourceProperties.getStaticLocations();
        final String[] indexLocations = new String[staticLocations.length];

        for(int i = 0; i < staticLocations.length; i++) {

            indexLocations[i] = staticLocations[i] + "index.html";

        }

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler(
                "/**/*.css",
                "/**/*.html",
                "/**/*.js",
                "/**/*.json",
                "/**/*.bmp",
                "/**/*.jpeg",
                "/**/*.jpg",
                "/**/*.gif",
                "/**/*.ico",
                "/**/*.png",
                "/**/*.ttf",
                "/**/*.wav",
                "/**/*.mp3",
                "/**/*.eot",
                "/**/*.svg",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.map"
        ).addResourceLocations(staticLocations);

        registry.addResourceHandler("/**")
                .addResourceLocations(indexLocations)
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {

                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        return location.exists() && location.isReadable() ? location : null;
                    }

                });

    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(jacksonObjectMapper());
        return converter;
    }

    @Bean
    @Primary
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JtsModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}

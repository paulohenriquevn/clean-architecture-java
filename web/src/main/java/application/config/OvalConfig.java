package application.config;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OvalConfig {

    @Bean
    public Validator validator() {

        AnnotationsConfigurer annotationsConfigurer = new AnnotationsConfigurer();
        annotationsConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);

        return new Validator(annotationsConfigurer);

    }
}

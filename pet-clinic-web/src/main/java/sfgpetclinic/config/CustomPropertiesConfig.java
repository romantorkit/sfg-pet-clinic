package sfgpetclinic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import sfgpetclinic.properties.Vet1;
import sfgpetclinic.properties.Vet2;

@Configuration
@PropertySource("classpath:custom.properties")
@PropertySources({
        @PropertySource("classpath:vet1.properties"),
        @PropertySource("classpath:vet2.properties")
})
public class CustomPropertiesConfig {

    @Value("${vet1.name.first}")
    private String vet1FirstName;
    @Value("${vet1.name.last}")
    private String vet1LastName;

    @Value("${vet2.name.first}")
    private String vet2FirstName;
    @Value("${vet2.name.last}")
    private String vet2LastName;

    @Bean
    public Vet1 vet1() {
        Vet1 vet1 = new Vet1();
        vet1.setFirstName(vet1FirstName);
        vet1.setLastName(vet1LastName);
        return vet1;
    }

    @Bean
    public Vet2 vet2() {
        Vet2 vet2 = new Vet2();
        vet2.setFirstName(vet2FirstName);
        vet2.setLastName(vet2LastName);
        return vet2;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

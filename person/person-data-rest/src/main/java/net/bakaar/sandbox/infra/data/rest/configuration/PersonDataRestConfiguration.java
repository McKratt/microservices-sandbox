package net.bakaar.sandbox.infra.data.rest.configuration;

import net.bakaar.sandbox.domain.number.BusinessNumberRepository;
import net.bakaar.sandbox.infra.data.rest.BusinessNumberFakeAdapater;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableConfigurationProperties(BusinessNumberServiceProperties.class)
public class PersonDataRestConfiguration {

//    @Bean
//    public BusinessNumberRepository businessNumberService(BusinessNumberServiceProperties properties, RestTemplate restTemplate) {
//        return new BusinessNumberRepositoryAdapter(properties, restTemplate);
//    }

    @Bean
    public BusinessNumberRepository fakeBusinessNumberService() {
        return new BusinessNumberFakeAdapater();
    }
}

package net.bakaar.sandbox.domain.person.configuration;

import net.bakaar.sandbox.domain.number.BusinessNumberRepository;
import net.bakaar.sandbox.domain.person.PersonApplicationConfiguration;
import net.bakaar.sandbox.domain.person.PersonApplicationService;
import net.bakaar.sandbox.domain.person.PersonRepository;
import net.bakaar.sandbox.domain.person.internal.PersonFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.springframework.test.util.ReflectionTestUtils.getField;

class PersonApplicationConfigurationTest {

    @Test
    void createPartnerApplicationService_should_instantiate_domainService() {
        //Given
        PersonApplicationConfiguration configuration = new PersonApplicationConfiguration();
        PersonRepository personRepository = mock(PersonRepository.class);
        BusinessNumberRepository numberRepository = mock(BusinessNumberRepository.class);

        //When
        PersonApplicationService returnedService = configuration.createPartnerApplicationService(personRepository, numberRepository);
        //Then
        assertThat(returnedService).isInstanceOf(PersonApplicationService.class);
        assertThat(getField(returnedService, "personRepository")).isSameAs(personRepository);
        PersonFactory factory = (PersonFactory) getField(returnedService, "personFactory");
        assertThat(factory).isNotNull().isInstanceOf(PersonFactory.class);
        assertThat(getField(factory, "businessNumberRepository")).isNotNull().isSameAs(numberRepository);
    }
}
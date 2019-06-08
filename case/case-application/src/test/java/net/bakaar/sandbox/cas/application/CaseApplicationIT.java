package net.bakaar.sandbox.cas.application;

import net.bakaar.sandbox.cas.domain.OpenCaseUseCase;
import net.bakaar.sandbox.cas.domain.repository.BusinessIdRepository;
import net.bakaar.sandbox.cas.domain.repository.CaseRepository;
import net.bakaar.sandbox.event.domain.DomainEventEmitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class CaseApplicationIT {

    @Autowired(required = false)
    private DomainEventEmitter eventEmitter;
    @Autowired(required = false)
    private CaseRepository repository;
    @Autowired(required = false)
    private BusinessIdRepository idProvider;
    @Autowired(required = false)
    private OpenCaseUseCase useCase;
    @Autowired(required = false)
    private RestTemplate restTemplate;

    @Test
    public void interfaces_should_be_instantiated() {
        assertThat(eventEmitter).isNotNull();
        assertThat(repository).isNotNull();
        assertThat(idProvider).isNotNull();
        assertThat(useCase).isNotNull();
        assertThat(restTemplate).isNotNull();
    }
}
package net.bakaar.sandbox.person.application.external;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusinessNumberRestClientTest {

    @Test
    public void fetch_should_call_rest_endpoint() {
        //Given
        long result = 98765432L;
        String url = "Http://TestUrl.net";
        RestTemplate restTemplate = mock(RestTemplate.class);
        given(restTemplate.getForObject(url, Long.class)).willReturn(result);
        BusinessNumberServiceProperties properties = mock(BusinessNumberServiceProperties.class);
        given(properties.getUrl()).willReturn(url);
        BusinessNumberRestClient client = new BusinessNumberRestClient(properties, restTemplate);
        //When
        long number = client.fetchPartnerNummer();
        //Then
        verify(restTemplate).getForObject(url, Long.class);
        verify(properties).getUrl();
        assertThat(number).isEqualTo(result);
    }
}
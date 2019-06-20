package net.bakaar.sandbox.rest.mapper;

import net.bakaar.sandbox.domain.person.Person;
import net.bakaar.sandbox.rest.dto.PartnerDTO;
import net.bakaar.sandbox.shared.domain.vo.PNumber;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonDomainDtoMapperTest {


    @Test
    public void mapToDto_should_map_correctly() {
        //Given
        String id = "P12345678";
        PNumber pNumber = PNumber.of(id);
        String name = "Bloch";
        String forename = "Joshua";
        LocalDate birthDate = LocalDate.now();
        PartnerDomainDtoMapper mapper = new PartnerDomainDtoMapper();
        Person inputPerson = Person.of(name, forename, birthDate).withId(pNumber).build();
        //When
        PartnerDTO dto = mapper.mapToDto(inputPerson);
        //Then
        assertThat(dto).isNotNull();
        assertThat(dto.getForename()).isEqualTo(forename);
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getBirthDate()).isSameAs(birthDate);
        assertThat(dto.getName()).isEqualTo(name);
    }
}
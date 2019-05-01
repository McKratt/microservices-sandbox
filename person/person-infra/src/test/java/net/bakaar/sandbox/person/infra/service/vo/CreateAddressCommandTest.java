package net.bakaar.sandbox.person.infra.service.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAddressCommandTest {

    @Test
    public void of_should_initialize_correctly() {
        //Given
        String address = "my Address";
        //When
        CreateAddressCommand command = CreateAddressCommand.of(address);
        //Then
        assertThat(command.getAddress()).isSameAs(address);
        assertThat(command.isMain()).isFalse();
    }

    @Test
    public void mainOf_should_initialize_correctly() {
        //Given
        String address = "my Address";
        //When
        CreateAddressCommand command = CreateAddressCommand.mainOf(address);
        //Then
        assertThat(command.getAddress()).isSameAs(address);
        assertThat(command.isMain()).isTrue();
    }
}
package net.bakaar.sandbox.person.domain.vo;

import lombok.Getter;

import java.time.LocalDate;

import static org.apache.commons.lang3.StringUtils.isEmpty;

//FIXME Is that really necessary to have all this controls in the command ?
@Getter
public class CreatePartnerCommand {

    private final String name;
    private final String forename;
    private final LocalDate birthDate;

    private CreatePartnerCommand(String name, String forename, LocalDate birthDate) {
        this.name = name;
        this.forename = forename;
        this.birthDate = birthDate;
    }

    public static CreatePartnerCommand of(String name, String forename, LocalDate birthDate) {
        checkStringParam(forename, "forename");
        checkStringParam(name, "name");
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("birthDate should have a value and should not be in the future");
        }
        return new CreatePartnerCommand(name, forename, birthDate);
    }

    private static void checkStringParam(String field, String fieldName) {
        if (field == null || isEmpty(field.trim())) {
            throw new IllegalArgumentException(String.format("%s should have a value", fieldName));
        }
    }
}

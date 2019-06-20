package net.bakaar.sandbox.infra.data.jpa.mapper;

import net.bakaar.sandbox.domain.address.Address;
import net.bakaar.sandbox.domain.shared.AddressNumber;
import net.bakaar.sandbox.infra.data.jpa.entity.AddressEntity;
import net.bakaar.sandbox.infra.data.jpa.entity.PersonAddressesEntity;

public class AddressEntityDomainMapper {
//    private final AddressJpaRepository repository;

//    public AddressEntityDomainMapper(AddressJpaRepository repository) {
//        this.repository = repository;
//    }

    public AddressEntity mapToEntity(Address address) {
//        return repository.findByAddressLine(address.getAddress())
//                .orElse(createNewEntity(address));
        return createNewEntity(address);
    }

    private AddressEntity createNewEntity(Address address) {
        AddressEntity entity = new AddressEntity();
        entity.setAddressLine(address.getAddress());
        entity.setNumber(address.getId().getValue());
        return entity;
    }

    public Address mapToDomain(PersonAddressesEntity entity) {
        Address address = Address.of(AddressNumber.of(entity.getAddress().getNumber()), entity.getAddress().getAddressLine());
        if (entity.isMain()) {
            address.makeItMain();
        }
        return address;
    }
}
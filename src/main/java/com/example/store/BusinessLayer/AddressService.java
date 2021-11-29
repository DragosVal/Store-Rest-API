package com.example.store.BusinessLayer;


import com.example.store.Entity.Address;
import com.example.store.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getSpecificAddress(long id) {
        if(!addressRepository.existsById(id))
            throw new IllegalStateException("The address can't be matched...");

        Optional<Address> address = addressRepository.findById(id);
        return address.get();
    }

    public void addNewAddress(Address address1) {
        Optional<Address> optional = addressRepository.findByCityAndNumberOfStreetAndStreet(address1.getCity(), address1.getNumberOfStreet(), address1.getStreet());
        if(optional.isPresent())
            throw new IllegalStateException("Address already exists!");

        addressRepository.save(address1);
    }

    public void deleteAddress(long id) {
        if(addressRepository.existsById(id))
            throw new IllegalStateException("ADDRESS DOES NOT EXIST...");

        addressRepository.deleteById(id);
    }

    public void replaceAddress(Long id, Address address){
        if(!addressRepository.existsById(id))
            throw new IllegalStateException("THE ID DOES NOT EXIST!!!");

        Address address1 = addressRepository.getOne(id);

        if(! address.equals(address1))
            throw new IllegalStateException("CANT REPLACE ADDRESS WITH NO CHANGES!!");

        address1.setCity(address.getCity());
        address1.setNumberOfStreet(address.getNumberOfStreet());
        address1.setStreet(address.getStreet());
        addressRepository.save(address1);
    }

}

package com.example.store.ApiLayer;

import com.example.store.BusinessLayer.AddressService;
import com.example.store.Entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Addresses")
public class AddressController {

    private final AddressService address;

    @Autowired
    AddressController(AddressService address){
        this.address = address;
    }

    @GetMapping("/AllAddresses")
    public List<Address> getAllAddresses(){
        return address.getAllAddresses();
    }

    @GetMapping("/SpecificAddress/{id}")
    public Address getSpecificAddress(@PathVariable long id){
        return address.getSpecificAddress(id);
    }

    @DeleteMapping("/DeleteAddress/{id}")
    public void deleteAddress(@PathVariable long id){
        address.deleteAddress(id);
    }

    @PostMapping("/addNewAddress")
    public void addNewAddress(@RequestBody Address address1){
        address.addNewAddress(address1);
    }

    @PutMapping("/replaceAddress/{id}")
    public void replaceAddress(@PathVariable long id, @RequestBody Address address1){
        address.replaceAddress(id, address1);
    }


}

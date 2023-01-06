package com.liquidbasepractice.service;

import com.liquidbasepractice.entities.Address;
import com.liquidbasepractice.entities.Someone;
import com.liquidbasepractice.repositories.AddressRepository;
import com.liquidbasepractice.repositories.SomeoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SomeoneService {

    @Autowired
    SomeoneRepository someoneRepository;

    @Autowired
    AddressRepository addressRepository;


    @Transactional
    public Someone save(Someone someone){
        return someoneRepository.save(someone);
    }

    @Transactional(readOnly = true)
    public List<Someone> findAll(){

        List<Someone> someoneList = someoneRepository.findAll();
//        System.out.println(someoneList.get(0).getName());
//
//        Address address = addressRepository.findById(someoneList.get(0).getId()).get();
//        System.out.println(address.getCity());
//
//        someoneList.get(0).setAddress(address);
//
//        System.out.println(someoneList.get(0).getAddress().getState());


        return someoneList;
    }

}

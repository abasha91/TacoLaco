package com.example.demo.Service.Taco;

import com.example.demo.Model.Taco;
import com.example.demo.Repository.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImplementaion implements TacoService {

    @Autowired
    TacoRepository tacoRepository;

    public Taco getByType(String type){
        return tacoRepository.findByType(type);
    }
}

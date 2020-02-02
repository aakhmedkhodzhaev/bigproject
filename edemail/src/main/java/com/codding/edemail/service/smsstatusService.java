package com.codding.edemail.service;

import com.codding.edemail.model.smsstatus;
import com.codding.edemail.repository.smsstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class smsstatusService {

    private final smsstatusRepository sSRepository;

    @Autowired
    public smsstatusService(@Qualifier("smsstatusRepository") smsstatusRepository sSRepository){
        this.sSRepository=sSRepository;
    }

    public smsstatus findById(Long transfer_id){
        return sSRepository.getOne(transfer_id);
    }

    public List<smsstatus> findAll(){
        return sSRepository.findAll();
    }

    public void deleteById(Long transfer_id){
        sSRepository.deleteById(transfer_id);
    }
}
package com.ekampus.services;

import com.ekampus.models.entities.Barang;
import com.ekampus.models.repositories.BarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BarangService {

    @Autowired
    private BarangRepo barangRepo;

    public Iterable<Barang> all(){
        return barangRepo.findAll();
    }
    public boolean destroy(Long id){
        try{
            barangRepo.deleteById(id);
            return true;
        }catch (Exception ignored){
            return false;
        }
    }
}

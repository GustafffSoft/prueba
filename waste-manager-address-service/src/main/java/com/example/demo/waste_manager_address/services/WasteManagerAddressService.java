package com.example.demo.waste_manager_address.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.waste_manager_address.dao.WasteManagerAddressDao;
import com.example.demo.waste_manager_address.models.WasteManagerAddressEntity;


@Service
public class WasteManagerAddressService {

    @Autowired
    private WasteManagerAddressDao wasteManagerAddressDao;

    public WasteManagerAddressEntity create(WasteManagerAddressEntity wasteManagerAddressEntity) {
        return wasteManagerAddressDao.save(wasteManagerAddressEntity);
    }

    public WasteManagerAddressEntity update(WasteManagerAddressEntity wasteManagerAddressEntity) {
        return wasteManagerAddressDao.save(wasteManagerAddressEntity);
    }

    public WasteManagerAddressEntity findById(Long id) {
        return wasteManagerAddressDao.findById(id).orElse(null);
    }

    public void delete(Long id) {
        wasteManagerAddressDao.deleteById(id);
    }
    
    
    public List<WasteManagerAddressEntity> byWasteManagerId(long wasteManagerId){
    	
    	return wasteManagerAddressDao.findByWasteMangerId(wasteManagerId);
    	
    }
}
package com.example.demo.waste_manager_address.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.waste_manager_address.models.WasteManagerAddressEntity;


@Repository
public interface WasteManagerAddressDao extends JpaRepository<WasteManagerAddressEntity, Long> {
    
	
	List<WasteManagerAddressEntity> findByWasteMangerId(long wasteMangerId);
}

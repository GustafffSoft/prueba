package com.example.demo.service;

import com.example.demo.dao.WasteManagerDao;
import com.example.demo.models.WasteManagerAddressModel;
import com.example.demo.models.WasteManagerEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WasteManagerService {

	@Autowired
	private WasteManagerDao wasteManagerDao;

	RestTemplate restTemplate;

	public WasteManagerEntity create(WasteManagerEntity wasteManagerEntity) {
		return wasteManagerDao.save(wasteManagerEntity);
	}

	public WasteManagerEntity update(WasteManagerEntity wasteManagerEntity) {
		return wasteManagerDao.save(wasteManagerEntity);
	}

	public WasteManagerEntity findById(Long id) {
		return wasteManagerDao.findById(id).orElse(null);
	}

	public List<WasteManagerAddressModel> getWasteManagerAddress(Long westManagerId) {

		List<WasteManagerAddressModel> wasteAddres = restTemplate.getForObject(
				"http://localhost:8081/waste-manager-address/getbywestmanager" + westManagerId, List.class);
		return wasteAddres;

	}
}
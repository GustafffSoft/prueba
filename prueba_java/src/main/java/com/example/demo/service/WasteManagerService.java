package com.example.demo.service;

import com.example.demo.dao.WasteManagerDao;
import com.example.demo.feignclients.WasteAddressFeignClient;
import com.example.demo.models.WasteManagerAddressModel;
import com.example.demo.models.WasteManagerEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WasteManagerService {

	private static final Logger logger = LoggerFactory.getLogger(WasteManagerService.class);

	@Autowired
	private WasteManagerDao wasteManagerDao;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WasteAddressFeignClient wasteAddressFeignClient;

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
		String url = "http://localhost:8081/waste-manager-address/getbywestmanager/" + westManagerId;
		try {
			logger.info("Llamando a la URL: {}", url);
			List<WasteManagerAddressModel> wasteAddres = restTemplate.getForObject(url, List.class);
			return wasteAddres;
		} catch (Exception e) {
			logger.error("Error al obtener las direcciones del Waste Manager con ID: {} desde la URL: {}",
					westManagerId, url, e);
			throw e;
		}
	}

	public WasteManagerAddressModel createWestAddres ( long wasteManagerId , WasteManagerAddressModel wasteManagerAddressModel) {
		wasteManagerAddressModel.setWasteManagerId(wasteManagerId);
		WasteManagerAddressModel wasteManagerAddressModelNew = wasteAddressFeignClient.create(wasteManagerAddressModel);
		return wasteManagerAddressModelNew;
	}
	
	public Map<String, Object> getWasteManagerAndAddress(long wasteManagerId) {
	    Map<String, Object> result = new HashMap<>();

	    WasteManagerEntity wasteManager = wasteManagerDao.findById(wasteManagerId).orElse(null);

	    if (wasteManager == null) {
	        result.put("mensaje", "no existe");
	        return result;
	    }

	    result.put("WasteManager", wasteManager);

	    List<WasteManagerAddressModel> wasteAddress = wasteAddressFeignClient.getWasteAddress(wasteManagerId);

	    if (wasteAddress.isEmpty()) {
	        result.put("WasteAddress", "no existen address");
	    } else {
	        result.put("WasteAddress", wasteAddress);
	    }

	    return result;
	}
}
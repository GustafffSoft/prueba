package com.example.demo.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.WasteManagerAddressModel;

@FeignClient(name = "waste-manager-address-service", url = "http://localhost:8081", path = "/waste-manager-address")
public interface WasteAddressFeignClient {

	
	@PostMapping("/create")
	WasteManagerAddressModel create(@RequestBody WasteManagerAddressModel wasteManagerAddressModel);
	
	@GetMapping("/getbywestmanager/{wasteManagerId}")
	List<WasteManagerAddressModel> getWasteAddress(@PathVariable("wasteManagerId") long wasteManagerId);
	
}

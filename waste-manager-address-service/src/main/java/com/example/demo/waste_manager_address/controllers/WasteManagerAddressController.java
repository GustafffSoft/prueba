package com.example.demo.waste_manager_address.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.waste_manager_address.models.WasteManagerAddressEntity;
import com.example.demo.waste_manager_address.services.WasteManagerAddressService;

@Controller
@RequestMapping("/waste-manager-address")
public class WasteManagerAddressController {

	@Autowired
	private WasteManagerAddressService wasteManagerAddressService;

	@PostMapping("/create")
	public ResponseEntity<WasteManagerAddressEntity> create(
			@RequestBody WasteManagerAddressEntity wasteManagerAddressEntity) {
		WasteManagerAddressEntity createdEntity = wasteManagerAddressService.create(wasteManagerAddressEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<WasteManagerAddressEntity> update(@PathVariable Long id,
			@RequestBody WasteManagerAddressEntity wasteManagerAddressEntity) {
		wasteManagerAddressEntity.setId(id);
		WasteManagerAddressEntity updatedEntity = wasteManagerAddressService.update(wasteManagerAddressEntity);
		return ResponseEntity.ok(updatedEntity);
	}

	@GetMapping("/getentity/{id}")
	public ResponseEntity<WasteManagerAddressEntity> findById(@PathVariable Long id) {
		WasteManagerAddressEntity entity = wasteManagerAddressService.findById(id);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		wasteManagerAddressService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hola mundo");
	}

	@GetMapping("/getbywestmanager/{wasteManagerId}")
	public ResponseEntity<List<WasteManagerAddressEntity>> getByWestManager(@PathVariable Long wasteManagerId) {
	    List<WasteManagerAddressEntity> westManagerAddress = wasteManagerAddressService.byWasteManagerId(wasteManagerId);
	    return ResponseEntity.ok(westManagerAddress);
	}
}
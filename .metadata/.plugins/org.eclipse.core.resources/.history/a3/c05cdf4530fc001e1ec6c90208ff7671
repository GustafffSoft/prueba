package com.example.demo.controllers;

import com.example.demo.models.WasteManagerAddressModel;
import com.example.demo.models.WasteManagerEntity;
import com.example.demo.service.WasteManagerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/waste-manager")
public class WasteManagerController {

    @Autowired
    private WasteManagerService wasteManagerService;

    @PostMapping("/create")
    public ResponseEntity<WasteManagerEntity> create(@RequestBody WasteManagerEntity wasteManagerEntity) {
        WasteManagerEntity createdEntity = wasteManagerService.create(wasteManagerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WasteManagerEntity> update(@PathVariable Long id, @RequestBody WasteManagerEntity wasteManagerEntity) {
        wasteManagerEntity.setId(id);
        WasteManagerEntity updatedEntity = wasteManagerService.update(wasteManagerEntity);
        return ResponseEntity.ok(updatedEntity);
    }

    @GetMapping("/getentity/{id}")
    public ResponseEntity<WasteManagerEntity> findById(@PathVariable Long id) {
        WasteManagerEntity entity = wasteManagerService.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hola mundo");
    }
    
    
    @GetMapping
    public ResponseEntity<List<WasteManagerAddressModel>> getWasteManagerAddress(@PathVariable("wastManageId" Long wastManageId)) {
    	
    	WasteManagerEntity wasteManager = wasteManagerService.ge
    }
}
package com.example.demo.controllers;


import com.example.demo.models.WasteCenterAuthorizationEntity;
import com.example.demo.service.WasteCenterAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/waste-center-authorization")
public class WasteCenterAuthorizationController {

    @Autowired
    private WasteCenterAuthorizationService wasteCenterAuthorizationService;

    @PostMapping
    public ResponseEntity<WasteCenterAuthorizationEntity> create(@RequestBody WasteCenterAuthorizationEntity wasteCenterAuthorizationEntity) {
        WasteCenterAuthorizationEntity createdEntity = wasteCenterAuthorizationService.create(wasteCenterAuthorizationEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCenterAuthorizationEntity> update(@PathVariable Long id, @RequestBody WasteCenterAuthorizationEntity wasteCenterAuthorizationEntity) {
        wasteCenterAuthorizationEntity.setId(id);
        WasteCenterAuthorizationEntity updatedEntity = wasteCenterAuthorizationService.update(wasteCenterAuthorizationEntity);
        return ResponseEntity.ok(updatedEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCenterAuthorizationEntity> findById(@PathVariable Long id) {
        WasteCenterAuthorizationEntity entity = wasteCenterAuthorizationService.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        wasteCenterAuthorizationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
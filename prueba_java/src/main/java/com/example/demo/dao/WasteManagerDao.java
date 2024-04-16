package com.example.demo.dao;


import com.example.demo.models.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerDao extends JpaRepository<WasteManagerEntity, Long> {
}
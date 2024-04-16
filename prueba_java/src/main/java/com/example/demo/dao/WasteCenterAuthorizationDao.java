package com.example.demo.dao;


import com.example.demo.models.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCenterAuthorizationDao extends JpaRepository<WasteCenterAuthorizationEntity, Long> {
}
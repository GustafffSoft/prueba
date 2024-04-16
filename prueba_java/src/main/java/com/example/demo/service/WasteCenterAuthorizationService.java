package com.example.demo.service;


import com.example.demo.dao.WasteCenterAuthorizationDao;
import com.example.demo.models.WasteCenterAuthorizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WasteCenterAuthorizationService {

	@Autowired
    private final WasteCenterAuthorizationDao wasteCenterAuthorizationDao;

    public WasteCenterAuthorizationService(WasteCenterAuthorizationDao wasteCenterAuthorizationDao) {
        this.wasteCenterAuthorizationDao = wasteCenterAuthorizationDao;
    }

    public WasteCenterAuthorizationEntity create(WasteCenterAuthorizationEntity wasteCenterAuthorizationEntity) {
        return wasteCenterAuthorizationDao.save(wasteCenterAuthorizationEntity);
    }

    public WasteCenterAuthorizationEntity update(WasteCenterAuthorizationEntity wasteCenterAuthorizationEntity) {
        return wasteCenterAuthorizationDao.save(wasteCenterAuthorizationEntity);
    }

    public WasteCenterAuthorizationEntity findById(Long id) {
        return wasteCenterAuthorizationDao.findById(id).orElse(null);
    }

    public void delete(Long id) {
        wasteCenterAuthorizationDao.deleteById(id);
    }
}
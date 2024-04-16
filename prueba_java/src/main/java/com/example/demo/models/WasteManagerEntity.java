package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "waste_manager_entity")
public class WasteManagerEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nombre;
     private String nif; 
     
//     private WasteManagerAddressEntity wasteManagerAddressEntity ;
    // @NotAudited
     @OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
     @JoinTable(name = "wastemanage_wastecenter", joinColumns = @JoinColumn(name = "wastemanage_is", nullable = false), inverseJoinColumns = @JoinColumn(name = "wastecenter_id)", nullable = false))
     private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();
     private Boolean isEnabled = Boolean.TRUE;
     private Long version = 0L;
     private Date createdDate;
     private Date lastModifiedDate;
}




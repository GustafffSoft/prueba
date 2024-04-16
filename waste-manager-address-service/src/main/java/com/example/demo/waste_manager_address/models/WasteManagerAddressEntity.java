package com.example.demo.waste_manager_address.models;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "waste_Manager_Address_Entity")
public class WasteManagerAddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String direccion;
	private Boolean isEnabled = Boolean.TRUE;
	private Long version = 0L;
	private Date createdDate;
	private Date lastModifiedDate;
	private Long wasteMangerId;
}

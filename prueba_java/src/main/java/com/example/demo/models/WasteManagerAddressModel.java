package com.example.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerAddressModel {
	
	private String direccion;
	private Boolean isEnabled = Boolean.TRUE;
	private Long version = 0L;
	private Date createdDate;
	private Date lastModifiedDate;
	private Long wasteManagerId;

}

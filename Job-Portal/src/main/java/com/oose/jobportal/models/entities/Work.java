package com.oose.jobportal.models.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "work")
public class Work {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "workID", nullable = false)
	private int workID;
	
	@Column(name = "workname", nullable = true, length = 30)
	private String workname;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeworkID", nullable = true)
	private TypeWork type_work;

	@OneToOne(targetEntity = DetailWork.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = true, name = "detailworkID", unique = true)
	private DetailWork detailwork;
	
	@Column(name = "location", nullable = true)
	private String location;
	
	@Column(name = "quantity", nullable = true)
	private int quantity;
	
	@Column(name = "date", nullable = true)
	private Date date;

	@Column(name = "image", nullable = true)
	private String image;

}

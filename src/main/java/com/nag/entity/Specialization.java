package com.nag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.query.criteria.internal.expression.function.LengthFunction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="specialization_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="spec_id_col")
	private Long id;
	
	
	
	
	@Column(name="spec_code_col",
			 length=10,
			 nullable=false,
			 unique=true
			)
	private String specCode;
	
	@Column(name="spec_name_col",
			 length=100,
			 nullable=false,
			 unique=true
			 )
	private String specName;
	
	@Column(name="spec_note_col",
			 length=100,
			 nullable=false,
			 unique=true
			)
	private String specNote;

}

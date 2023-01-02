package com.springboot.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
	 
	
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
      
      @Column(name="first_name")
      private String firstName;
      
      @Column(name="last_name")
      private String lastName;
      
	  private String email;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	


	
	}
	  
	  
	  

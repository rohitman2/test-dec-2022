package com.springboot;

import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.springboot.entity.Student;
import com.springboot.repository.StudentRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class TestContainersApplicationTests {

	@Container
	private static MySQLContainer mySQLContainer = new MySQLContainer(dockerImageName: "mysql:latest");
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	//given/when/then format -BDD style
	@Test
	public void givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception 
	{
		System.out.println(mySQLContainer.getDatabaseName());
		System.out.println(mySQLContainer.getPassword());
		System.out.println(mySQLContainer.getUsername());
		System.out.println(mySQLContainer.getJdbcUrl());
	
		// given - setup or precondition
			List<Student> students =
					List.of(Student.builder().firstName("Ramesh").lastName("faadatare").email("ramesh@gmail.com").build(),
							Student.builder().firstName("tony").lastName("stark").email("tony@gmail.com").build());	
				studentRepository.saveAll(students);
		
				// when - action
				ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"));
				
				
				// then - verify the output
				response.andExpect(MockMvcResultMatchers.status().isOk());
				response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(students.size())));
	}
	
}

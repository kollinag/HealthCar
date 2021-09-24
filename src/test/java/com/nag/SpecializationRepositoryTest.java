package com.nag;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nag.entity.Specialization;
import com.nag.repo.SpecializationRepository;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepository repo;
	
	/**
	 * Save Operation
	 */

	
	@Test
	@Order(1)
	
	public void testsaveSpecialization() {
		Specialization spec=new Specialization(null,"CRDLS","Cardiologists","There're experts on the heart and blood vessels");
		Specialization save = repo.save(spec);
		
		assertNotNull(save.getId(),"Employee inserted succesfully");
		
		
	}
	
	
	@Test
	@Order(2)
	@Disabled
	public void testSpecFetchAll() {
		List<Specialization> findAll = repo.findAll();
		assertNotNull(findAll);
		if(findAll.isEmpty()) {
			fail("data not found");
		}
	}
	
	
	
}

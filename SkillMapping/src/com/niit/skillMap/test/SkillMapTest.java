package com.niit.skillMap.test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;


class SkillMapTest {

	Repository repository;

	@Before
	public void setUp() throws Exception {
		repository=new Repository();
	}

	@After
	public void tearDown() throws Exception {
		repository=null;
	}


	@Test
	public void testInsert()
	{
		Employee employee=new Employee();
		employee.setEmployeeId(3);
		employee.setEmployeeName("bhoomi");
		employee.setEmployeeEmail("bhoomi@gmail.com");
		employee.setEmployeePhone("9083765634");
		employee.setEmployeeCity("Baroda");
		employee.setEmployeeQualification("BEIT");
		employee.setEmployeeSkill("java,jsp");
		employee.setEmployeeCertification("ocjp");
		employee.setEmployeePassword("Abc@123");
		employee.setEmployeeRole("employee");
		employee.setStatus(false);
		assertEquals("record insertion",1,repository.insert(employee));
	}
	
	@Test
	public void testUpdate()
	{
		Employee employee=new Employee();
		//employee.setEmployeeId(3);
		employee.setEmployeeName("bhoomi");
		employee.setEmployeeEmail("bhoomi@gmail.com");
		employee.setEmployeePhone("9083765634");
		employee.setEmployeeCity("Baroda");
		employee.setEmployeeQualification("BEIT");
		employee.setEmployeeSkill("java,jsp,servlet");
		employee.setEmployeeCertification("ocjp");
		employee.setEmployeePassword("Abc@123");
		employee.setEmployeeRole("employee");
		employee.setStatus(false);
		assertEquals("record insertion",1,repository.updateEmployee(employee, 3));
	}
}


package com.niit.skillMap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import javax.servlet.jsp.el.Expression;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.niit.skillMap.model.Employee;
import com.niit.skillMap.model.Repository;


class SkillMapTest {

	Repository repository=new Repository();

	@Before
	public void setUp() throws Exception {
		//repository=new Repository();
	}

	@After
	public void tearDown() throws Exception {
		repository=null;
	}

	@Test
	public void testInsert1()
	{
		Employee employee=new Employee();
		employee.setEmployeeId(4);
		employee.setEmployeeName("pooja");
		employee.setEmployeeEmail("pooja@");
		employee.setEmployeePhone("90837");
		employee.setEmployeeCity("Baroda");
		employee.setEmployeeQualification("BEIT");
		employee.setEmployeeSkill("java,jsp");
		employee.setEmployeeCertification("ocjp");
		employee.setEmployeePassword("Abc@123");
		employee.setStatus(false);
		employee.setEmployeeRole("employee");
		
		assertEquals("record insertion",1,repository.insert(employee));
	}
	
	@Test
	public void testInsert2()
	{
		Employee employee=new Employee();
		employee.setEmployeeId(9);
		employee.setEmployeeName("sona");
		employee.setEmployeeEmail("sonam@gmail.com");
		employee.setEmployeePhone("9083765634");
		employee.setEmployeeCity("mumbai");
		employee.setEmployeeQualification("BEIT");
		employee.setEmployeeSkill("java,jsp");
		employee.setEmployeeCertification("ocjp");
		employee.setEmployeePassword("Abc@123");
		employee.setStatus(false);
		employee.setEmployeeRole("employee");
		
		assertEquals("record insertion",1,repository.insert(employee));
	}
	
	@Test
	public void testUpdate()
	{
		Employee employee=new Employee();
		employee.setEmployeeId(3);
		employee.setEmployeeName("sonam");
		employee.setEmployeeEmail("sonam@gmail.com");
		employee.setEmployeePhone("9083765634");
		employee.setEmployeeCity("mumbai");
		employee.setEmployeeQualification("BEIT");
		employee.setEmployeeSkill("java,jsp,servlet");
		employee.setEmployeeCertification("ocjp");
		employee.setEmployeePassword("Abc@123");
		employee.setEmployeeRole("employee");
		employee.setStatus(false);
		assertEquals("record insertion",1,repository.updateEmployee(employee, 3));
	}
	
	@Test
	public void testDeletebyId()
	{		
		assertEquals("record insertion",1,repository.deleteEmployee(5));
	}
	
	//@Test
	/*public void testGetEmployee(){
	    try{
	        Expression myReturnedObject = (Expression) repository.getAllEmployeeDetails();
	        assertNotNull(myReturnedObject);//check if the object is != null
	        //checks if the returned object is of class Expression
	        assertTrue( true, myReturnedObject instanceof Expression);
	    }catch(Exception e){
	        // let the test fail, if your function throws an Exception.
	        fail("got Exception, i want an Expression");
	     }
	}*/
}


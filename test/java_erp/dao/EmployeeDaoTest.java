package java_erp.dao;

import static org.junit.Assert.*;
import java_erp.dao.impl.EmployeeDaoImpl;
import java_erp.dto.Employee;
import java_erp.dto.Title;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeDaoTest {
	private static EmployeeDaoImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = EmployeeDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectEmployeeAll() {
		System.out.println("testSelectEmployeeAll()");
	}

	@Test
	public void testSelEmployeeByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void test01InsertEmployee() {
		System.out.println("test01InsertEmployee()");
		Employee newEmp = new Employee(1004, "신혜리", null, null, 2500000, null);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02InsertEmployee() {
		System.out.println("test02InsertEmployee()");
		Title title = new Title(2);
		Employee newEmp = new Employee(1011, "신혜리1", title, null, 1500000, null);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test01UpdateEmployee() {
		System.out.println("test01UpdateEmployee()");
		Employee newEmp = new Employee(1010, "신혜리", null, null, 1800000, null);
		dao.insertEmployee(newEmp);
		
		//수정
		newEmp.setEmpName("최명기");
		newEmp.setSalary(1500000);
		int res = dao.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		
		dao.deleteEmployee(newEmp);
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

}

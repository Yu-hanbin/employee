package java_erp;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java_erp.dao.DepartmentDao;
import java_erp.dto.Department;
import java_erp.util.JdbcUtil;
import java_erp.dao.impl.DepartmentDaoImpl;

public class DepartmentDaoTest {
	private static DepartmentDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("테스트 클래스 시작 전 - setUpBeforeClass()");
		dao = DepartmentDaoImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("테스트 클래스 종료 후 - tearDownAfterClass()");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("테스트 메서드 수행 전 - setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("테스트 메서드 수행 후 - tearDown()");
	}

	@Test
	public void test01SelectDepartmentByAll() {
		System.out.println("Test 메서드 - test01SelectDepartmentByAll()");
		ArrayList<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectDepartmentByNo() {
		System.out.println("Test 메서드 - test02SelectDepartmentByNo()");
		Department selectDept = dao.selectDepartmentByNo(new Department(2));
		Assert.assertNotNull(selectDept);
		System.out.println(selectDept);
	}

	@Test
	public void test03InsertDepartment() {
		System.out.println("Test 메서드 - test03InsertDepartment()");
		Department newDept = new Department(4, "총무", 25);
		int res = dao.insertDepartment(newDept);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05DeleteDepartment() {
		System.out.println("Test 메서드 - test05DeleteDepartment()");
		//추가
		Department dept = new Department(4, "총무",25);
		dao.insertDepartment(dept);
		//삭제-검증
		int res = dao.deleteDepartment(dept);
		Assert.assertEquals(1, res);
		
		Department selDept = dao.selectDepartmentByNo(dept);
		Assert.assertNull(selDept);
	}

	public Department selectDepartmentByNo(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Department> selectDepartmentByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public DepartmentDaoTest(DepartmentDao dao) {
		this.dao = dao;
	}

	public int insertDepartment(Department department) {
		String sql = "insert into department values (?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package java_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import java_erp.dto.Department;
import java_erp.dto.Employee;
import java_erp.dto.Title;
import java_erp.util.JdbcUtil;

public class EmployeeDaoImpl {
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();

	public static EmployeeDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public ArrayList<Employee> selectEmployeeByAll() {
		String sql = "select empno, empname, title, manager, salary, dno from employee";
		ArrayList<Employee> list = null;
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs) {
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");
		String empName = rs.getString("empname");
		
		Title title = new Title(rs.getInt("title"));
		Employee manager = new Employee(rs.getInt("manager"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept"));
		return new Employee(empNo, empName, title, manager, salary, dept);
	}
	
	@Override
	public ArrayList<Employee> selectEmployeeByNo() {
		String sql = "select empno, empname, title, manager, salary, dno from employee";
		ArrayList<Employee> list = null;
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs) {
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	public int insertEmployee(Employee emp) {
		String sql = "insert into Employee values (?, ?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			try {
				pstmt.setInt(3, emp.getTitle() == null ? null : emp.getTitle().getCode());
			} catch (NullPointerException e) {
				pstmt.setNull(3, Types.INTEGER);
			}
			try {
				pstmt.setInt(4, emp.getManager() == null ? null : emp.getManager().getEmpNo());
			} catch (NullPointerException e) {
				pstmt.setNull(3, Types.INTEGER);
			}
			pstmt.setInt(5, emp.getSalary());
			try {
				pstmt.setInt(6, emp.getDept() == null ? null : emp.getDept().getDeptNo());
			} catch (NullPointerException e) {
				pstmt.setNull(3, Types.INTEGER);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int updateEmployee(Employee emp) {
		String sql = "Update employee "
				+ "       set empname = ?, salary = ?, title = ?, manager = ?, dno = ?"
				+ "     where empno = ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, emp.getEmpName());
			pstmt.setInt(2, emp.getSalary());
			try {
				pstmt.setInt(3, emp.getTitle().getCode());
			} catch(NullPointerException e) {
				pstmt.setNull(3, Types.INTEGER);
			}
			try {
				pstmt.setInt(4, emp.getManager().getEmpNo());
			} catch(NullPointerException e) {
				pstmt.setNull(4, Types.INTEGER);
			}
			try {
				pstmt.setInt(5, emp.getDept().getDeptNo());
			} catch(NullPointerException e) {
				pstmt.setNull(5, Types.INTEGER);
			}
			pstmt.setInt(6, emp.getEmpNo());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return 0;	
	}
	
	
	public int deleteEmployee(Employee emp) {
		String sql = "delete from Employee where empno = ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, emp.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;	
		}
}

package java_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_erp.dao.DepartmentDao;
import java_erp.dto.Department;
import java_erp.dto.Title;
import java_erp.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	public DepartmentDaoImpl() {

	}

	@Override
	public ArrayList<Department> selectDepartmentByAll() {
		String sql = "select deptno, deptname, floor from department";
		ArrayList<Department> list = new ArrayList<Department>();
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			list = new ArrayList<Department>();
			while (rs.next()) {
				list.add(getDepartment(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 1. DB접속(시간이 많이걸림) <- Connection Pool 
		 * 2. SQL을 Database에 맞은 명령문으로 변경(스트링->명령문변경) 
		 * 3. SQL에서 ?를 입력 매개변수 값으로 치환해서 SQL명령문을 완성 
		 * 4. SQL명령문 실행(select : executeQuere 
		 				  Insert, Update, Delete : executeUpdate) 
		 * 5. 만약 executeQuery일 경우 :
		 * SQL결과를 클래스로 변환
		 */
		return list;

	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		//deptno, deptname, floor
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		Department newDept = new Department(deptNo, deptName, floor);
		return newDept;
	}



	@Override
	public Department selectDepartmentByNo(Department department) {
		return null;
	}

	@Override
	public int insertDepartment(Department department) {
		return 0;
	}

	@Override
	public int updateDepartment(Department department) {
		return 0;
	}

	@Override
	public int deleteDepartment(Department department) {
		return 0;
	}

}

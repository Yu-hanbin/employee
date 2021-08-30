package java_erp.dto;

public class Department {

	public int DeptNo;
	public String DeptName;
	public int Floor;

	public Department(int deptNo, String deptName, int floor) {
		DeptNo = deptNo;
		DeptName = deptName;
		Floor = floor;
	}

	public Department(int deptNo) {
		DeptNo = deptNo;
	}

	public int getDeptNo() {
		return DeptNo;
	}

	public void setDeptNo(int deptNo) {
		DeptNo = deptNo;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public int getFloor() {
		return Floor;
	}

	public void setFloor(int floor) {
		Floor = floor;
	}

	@Override
	public String toString() {
		return String.format("Department [DeptNo=%s, DeptName=%s, Floor=%s]", DeptNo, DeptName, Floor);
	}

}
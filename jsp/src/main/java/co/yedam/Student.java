package co.yedam;

public class Student {
	private String stdNo;
	private String stdName;
	private String phone;
	private String bldType;
	private String createDate0;
	
	public String getStdNo() {
		return stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public String getPhone() {
		return phone;
	}
	public String getBldType() {
		return bldType;
	}
	public String getCreateDate0() {
		return createDate0;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setBldType(String bldType) {
		this.bldType = bldType;
	}
	public void setCreateDate0(String createDate0) {
		this.createDate0 = createDate0;
	}
	
	// toString 오버라이드
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", phone=" + phone + ", bldType=" + bldType
				+ ", createDate0=" + createDate0 + "]";
	}
	

	
}

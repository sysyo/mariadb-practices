package bookmall.vo;

public class MemberVo {
	private int memberNo;
	private String memberName;
	private String memberEmail;
	private String memberPass;
	private String memberPhone;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ ", memberPass=" + memberPass + ", memberPhone=" + memberPhone + "]";
	}
	
}

package ca.ntro.core.reflection.mock.objects;

public class SimpleObject02 {
	
	private String attr01;
	private int attr02;

	public String getAttr01() {
		return attr01;
	}

	public void setAttr01(String attr01) {
		this.attr01 = attr01;
	}

	public int getAttr02() {
		return attr02;
	}

	public void setAttr02(int attr02) {
		this.attr02 = attr02;
	}
	
	
	
	
	
	
	public SimpleObject02() {
	}

	public SimpleObject02(String attr01, int attr02) {
		setAttr01(attr01);
		setAttr02(attr02);
	}
	

}

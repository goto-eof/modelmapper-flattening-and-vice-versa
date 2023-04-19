package andrei.modelmapper.dto;

public class PersonDTO {

	private boolean a;
	private boolean b;
	private boolean c;

	public boolean isA() {
		return a;
	}

	public void setA(boolean a) {
		this.a = a;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public boolean isC() {
		return c;
	}

	public void setC(boolean c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "PersonDTO [a=" + a + ", b=" + b + ", c=" + c + "]";
	}







}

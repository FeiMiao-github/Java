package enumerationMethod;

public enum SizeDemo {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private String abbreviration;
	
	private SizeDemo(String abbreviration) {this.abbreviration = abbreviration;}
	public String getAbbreviration() {
		return abbreviration;
	}
}

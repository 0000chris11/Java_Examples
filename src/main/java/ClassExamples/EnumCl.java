package ClassExamples;

public enum EnumCl {
	Sora("dumb","16"),
	Riku("ehh","17"),
	Kairi("actually a great character","16"),
	Roxas("cool guy","16 maybe"),
	Axel("very likeble","?"),
	Xion("sniff sniff","16 maybe too"),
	Terra("he is fine...","idr");
	
	private final String description;
	private final String age;
	
	
	EnumCl(String dc, String a) {
		description = dc;
		age = a;
	}
	public String getDesc() {
		return description;
	}
	public String getAge() {
		return age;
	}
}

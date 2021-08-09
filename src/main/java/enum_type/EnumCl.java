package enum_type;

public enum EnumCl {

	SORA("Kingdom Key","16"),
	RIKU("IDR","17"),
	KAIRI("Destiny Embrace","16 2"),
	ROXAS("Oathkeeper & Oblivion","16 maybe"),
	AXEL("IDR 2","?"),
	XION("Kingdom Key Copy","16 maybe 2"),
	TERRA("IDR 3","? 2");
	
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

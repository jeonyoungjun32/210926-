package vo;

public class Ice {
	private int id; 		// 상품아이디
	private String name;  	// 아이스크림 이름
	private String kind; 	// 아이스크림 종류
	private String country; // 아이스크림 설명
	private int price; 		// 가격
	private String image;	 // 이미지
	private int readcount; 	//조회수
	private int count;		//갯수

	public Ice() {
		// TODO 기본 생성자 만들고
	}

	public Ice(int id, String name , String kind, String country, int price, String image,int readcount,int count) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.country = country;
		this.price = price;
		this.image = image;
		this.readcount = readcount;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ice [id=" + id + ", kind=" + kind + ", country=" + country + ", price=" + price + ", image=" + image
				+ "]";
	}

}

package mg.tife.graphql.data;

public class CarInput {
	
	private String name;
	private String photo;
	private String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Car getCarEntity() {
		Car car = new Car();
		car.setName(name);
		car.setPhoto(photo);
		car.setPrice(price);
		return car;
	}
}
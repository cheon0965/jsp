package co.yedam.app.xml;

public class Restaurant {
	private Chef chef;
	
	Restaurant(){
		System.out.println("ㅇ");
	};
	
	Restaurant(Chef chef){
		this.chef = chef;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}

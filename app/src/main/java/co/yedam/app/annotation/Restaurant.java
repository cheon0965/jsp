package co.yedam.app.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	@Autowired
	private Chef chef;
	
	Restaurant(){
		System.out.println("어노테이션 1");
	};
	
	Restaurant(Chef chef){
		this.chef = chef;
		System.out.println("어노테이션 2");
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
		System.out.println("세터");
	}
	
	public void run() {
		chef.cooking();
	}
}

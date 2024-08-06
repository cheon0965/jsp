package co.yedam.app.annotation;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	Chef(){
		System.out.println("쉐프");
	};
	public void cooking() {
		System.out.println("쉐프 쿠킹");
	}
}

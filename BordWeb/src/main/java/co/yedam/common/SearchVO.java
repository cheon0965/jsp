package co.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 검색조건을 담는 클래스
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchVO {
	public int page;
	public String searchCondition;
	public String keyword;
	
}

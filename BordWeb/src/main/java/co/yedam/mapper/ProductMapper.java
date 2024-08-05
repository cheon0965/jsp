package co.yedam.mapper;

import co.yedam.vo.TemplateVO;

public interface ProductMapper {
	int deleteProdAll();
	int insertTemplate(TemplateVO[] vo);
	int insertTemplate1(TemplateVO vo);
}

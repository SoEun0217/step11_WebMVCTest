package kosta.mvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository //id="productDAOImpl"
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private List <ProductDTO>list;
		
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		String code = productDTO.getCode();
		int result = 0;
		for(ProductDTO p:list) {
			if(p.getCode().equals(code)) {
				throw new MyErrorException("코드가 중복입니다.");
			}else {
				list.add(productDTO);
				result =1;
			}
		}
		return result;
		
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = 0;
		for(ProductDTO p:list) {
			if(p.getCode().equals(code)) {
				list.remove(p);
				result =  1;
			}
		}
			
		return result;
	}

}

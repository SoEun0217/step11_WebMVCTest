package kosta.mvc.model.dao;

import java.util.Iterator;
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
		//중복체크하자..
		if(this.searchByCode(productDTO.getCode())!=null) {
			throw new MyErrorException(productDTO.getCode()+"코드는 중복입니다.");
		}
		
		list.add(productDTO);
		return 1;
		
	}

	@Override
	public int delete(String code) throws MyErrorException {
		ProductDTO dto = this.searchByCode(code);
		if(dto==null) {
			throw new MyErrorException(code+"에 해당하는 정보를 찾을 수 없습니다.");
		}
		list.remove(dto);
		return 1;
	}
	
	/**
	 * 상품코드에 해당하는 상품정보 가져오기
	 * */
	@Override
	public ProductDTO searchByCode(String code) throws MyErrorException {
		for(ProductDTO dto:list) {
			if(dto.getCode().equals(code)) {
				return dto;
			}
		}
		return null;//없으면 null리턴..
	}
	

}

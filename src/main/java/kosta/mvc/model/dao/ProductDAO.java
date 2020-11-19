package kosta.mvc.model.dao;

import java.util.List;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

public interface ProductDAO {
   /**
    * 검색
    * */
	List<ProductDTO> select();
	
	/**
	 * 등록
	 * */
	int insert(ProductDTO productDTO)throws MyErrorException;
	
	/**
	 * 삭제
	 * */
	 int delete(String code)throws MyErrorException;
	 
	 /**
	  * 상품코드에 해당하는 상품 정보 검색하기
	  * */
	 ProductDTO searchByCode(String code)throws MyErrorException;
}











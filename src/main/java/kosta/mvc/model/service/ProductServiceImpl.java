package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dao.ProductDAOImpl;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service("service")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductDTO> select() {
		List <ProductDTO> list = dao.select();
		return list;
	}
	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		int result = dao.insert(productDTO);
		return result ;
	}
	@Override
	public int delete(String code) throws MyErrorException {
		int result = dao.delete(code);
		return result;
	}

}
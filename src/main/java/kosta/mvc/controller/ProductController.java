package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	/**
	 * 전체검색 요청
	 * */
	@RequestMapping("/index.kosta")
	public ModelAndView select(){
		List <ProductDTO> list = service.select();
		
		return new ModelAndView("productList","list",list);
	}
	
	@RequestMapping("insertForm.kosta")
	public String insertForm() {
		return "insertForm";
	}
	
	@RequestMapping("insert.kosta")
	public String insert(ProductDTO productDTO) {
		String view="productList";
		try {
			int result = service.insert(productDTO);
			if(result==0) {
				view="productList";
			}else {
				view="productList";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
	@ExceptionHandler(value=MyErrorException.class)
	public ModelAndView exception(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productList");
		List<ProductDTO> list = service.select();
		mv.addObject("list",list);
		return mv;
	}
	
}

package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/**
	 * 상품등록폼
	 * */
	@RequestMapping("{url}.kosta")
	public void insertForm() {	}//요청에 들어오는 mapping의 이름과 같은 뷰로 이동한다.
	
	/**
	 * 상품등록하기
	 * */
	@PostMapping("/insert.kosta")
	public String insert(ProductDTO productDTO)throws MyErrorException {
		//post방식 한글인코딩을 web.xml에 필터처리해준다.
		//exception을 다른데서 처리해야하므로 던져야한다...
		
		service.insert(productDTO);
		return "redirect:index.kosta";//controller에 있는 requestMapping을 찾는다
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/{code}")
	public String delete(@PathVariable String code)throws MyErrorException {//?code=A01일 때는 어노테이션이 없는 것 {}안의 변수와 parameter변수같게!
		service.delete(code);
		return "redirect:index.kosta";
	}
	
	@RequestMapping("/read.kosta")
	public ModelAndView detail(String code)throws MyErrorException {
		ProductDTO dto = service.detail(code);
		return new ModelAndView("detailForm", "dto",dto);
	}
	
	
	@ExceptionHandler(value=MyErrorException.class)
	public ModelAndView exception(MyErrorException e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errMessage",e.getMessage());
		return mv;
	}
	
	
	
}

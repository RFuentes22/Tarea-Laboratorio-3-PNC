package com.uca.capas.products.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.products.domain.Product;

@Controller
public class ProductController {
	private List<Product> products = new ArrayList<Product>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		products.clear();
		products.add(new Product(0,"Life is Strange",20));
		products.add(new Product(1,"GTA V",15));
		products.add(new Product(2,"COD",30));
		products.add(new Product(3,"Last of us",40));
		products.add(new Product(4,"Assassins Creed III",45));
		
		mav.setViewName("productos");
		mav.addObject("product",new Product());
		mav.addObject("producto",products);
		

		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		String resul = products.get(product.getId()).getNombre();
		mav.addObject("resul", resul);
		
		if(products.get(product.getId()).getCantidad() < product.getCantidad() ||  product.getCantidad() < 1) {
			mav.setViewName("/error");
			
		}
		else {
			mav.setViewName("/compra");
			
		}
		
		return mav;
	}
}

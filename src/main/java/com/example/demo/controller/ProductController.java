package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ProductService;
import com.example.demo.entity.ProductEntity;
import com.example.demo.model.ProductModel;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/productform")
    public String getProductForm() {
		
     return "add-Product";
	}

   @PostMapping ("/saveproduct")
   public String saveproduct(ProductModel productModel) {
	   productService.SaveProductDetails(productModel);
	   return "Success";
   }
  

    @GetMapping("/getallproducts")
    public String getallproducts(Model model)
    {
    	List<ProductEntity> products = productService.getAllProducts();
    	model.addAttribute("products", products);
    	return "product-list";
    	
    }
  @GetMapping("/searchform")
  public String getsearchform()
  {
	  return "search-product";
  }

 @PostMapping("/searchbyid")
 public String searchById(@RequestParam Long id,Model model)
 {
	 ProductEntity product= productService.searchById(id);
	 model.addAttribute("product",product);
	 return "search-product";
 }
 
 @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable Long id)
  {
 productService.deleteproductById(id);
  return "redirect:/getallproducts";
  }
  
 @GetMapping("/edit/{id}")
 public String editById(@PathVariable Long id,Model model)
 { 
	 ProductModel productModel=productService.editById(id);
	 model.addAttribute("product",productModel);
	 model.addAttribute("id",id);
	 return "edit-form";
 }
 @PostMapping("/saveditproduct/{id}")
 public String updateData(@PathVariable Long id,ProductModel productModel)
 {
	 productService.updateData(productModel,id);
	 return "redirect:/allproducts";
	 		
 }
} 

  


  
    
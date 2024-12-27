package com.example.demo.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.ProductModel;

@Service
public class ProductService {
        @Autowired
        ProductRepository productRepository;  
       public void SaveProductDetails(ProductModel productModel)
       {
    	     double discountprice;
             discountprice=productModel.getPrice()*productModel.getDiscountRate()/100;
		 
			 double offerprice;
		     offerprice=productModel.getPrice()-discountprice;
		     
		     double stockvalue;
		     stockvalue=productModel.getPrice()* productModel.getQuantity();
		
			 double finalprice ;
		     finalprice=productModel.getPrice() + productModel.getTaxprice();
 
	        ProductEntity productEntity=new ProductEntity();
            productEntity.setName(productModel.getName());
		    productEntity.setBrand(productModel.getBrand());
		    productEntity.setMadeIn(productModel.getMadeIn());
		    productEntity.setPrice(productModel.getPrice());
		    productEntity.setQuantity(productModel.getQuantity());
		    productEntity.setDiscountRate(productModel.getDiscountRate());
		    productEntity.setTaxprice(productModel.getTaxprice());
		    productEntity.setFinalprice(finalprice);
		    productEntity.setOfferprice(offerprice);
		    productEntity.setDiscountprice(discountprice);
		    productEntity.setStockvalue(stockvalue);
		    
		    
		    productRepository.save(productEntity);
       
      }
	public List<ProductEntity>getAllProducts()
	{
	  List<ProductEntity> products=productRepository.findAll();
	  return products;
	  
	}

    public ProductEntity searchById(Long id)
    {
    	Optional<ProductEntity> optionalData=productRepository.findById(id);
	     if(optionalData.isPresent())
	      {
		     ProductEntity product=optionalData.get();
		       return product;
	       }
	       else 
	       {
		      return null;
	       }
    }
	
public void deleteproductById(Long Id)
{
	
productRepository.deleteById(Id);
}

public ProductModel editById(Long id){

	Optional<ProductEntity> optional=productRepository.findById(id);
	
	if(optional.isPresent())
	{
		ProductEntity eproduct=optional.get();
		ProductModel product =new ProductModel();
		product.setName(eproduct.getName());
		product.setBrand(eproduct.getBrand());
		product.setMadeIn(eproduct.getMadeIn());
		product.setPrice(eproduct.getPrice());
		product.setQuantity(eproduct.getQuantity());
		product.setDiscountRate(eproduct.getDiscountRate());
	    product.setTaxprice(eproduct.getTaxprice());
	    
	     return product;
	}
	else
	{
		return null;
	
	}
}
   public void updateData(Long id,ProductModel model)
   {
	 Optional<ProductEntity> optionaldata=productRepository.findById(id);
	 if(optionaldata.isPresent())
	 {
		 ProductEntity entity=optionaldata.get();
		 entity.setName(model.getName());
		 entity.setBrand(model.getBrand());
		 entity.setMadeIn(model.getMadeIn());
		 entity.setQuantity(model.getQuantity());
		 entity.setDiscountRate(model.getDiscountRate());
		 entity.setTaxprice(model.getTaxprice());
		double discountprice;
		discountprice=model.getPrice()*(model.getDiscountRate()/100);
		double offerprice;
		offerprice=model.getPrice()-discountprice;
		
		double finalprice;
		finalprice=model.getTaxprice()+offerprice;
		
		double stockvalue;
		stockvalue=model.getQuantity()*offerprice+model.getPrice()/100;
		entity.setDiscountprice(discountprice);	 
		entity.setOfferprice(offerprice);
		entity.setFinalprice(finalprice);
		entity.setStockvalue(stockvalue);
		productRepository.save(entity);
   }
 }
public void updateData(ProductModel productModel, Long id) {
	// TODO Auto-generated method stub
	
}
}	
		
		
	



	
	

	
	




    
       
	 


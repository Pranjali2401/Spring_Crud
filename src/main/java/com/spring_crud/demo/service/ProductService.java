package com.spring_crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_crud.demo.dao.ProductDao;
import com.spring_crud.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public Product addProduct(Product product) {
		Product pr = productDao.save(product);
		return pr;
	}

	public Product getProduct(long id) {
//		Product pro1 = productDao.getById(id);
		return productDao.findById(id).get();
	}

	public List<Product> getAllProduct() {
		List<Product> list = productDao.findAll();
		return list;
	}

	public Product updateProduct(Product product, long id) {
		Product pro = productDao.getById(id);
		pro.setProductName(product.getProductName());
		pro.setProductPrice(product.getProductPrice());
		pro.setProductCompany(product.getProductCompany());

		productDao.save(pro);

		return product;
	}

	public Boolean deleteProduct(long id) {
		productDao.deleteById(id);
		;
		return true;

	}

}

package com.application.serviceInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.application.dto.ProdcutDTO;
import com.application.model.Categories;
import com.application.model.Product;

public interface ProductServiceInterface {

	public boolean addProductDetails(ProdcutDTO prodcutDTO);

	public List<Product> viewProductList();

	public Optional<Product> findByProductId(long id);

	public boolean deleteByProductId(long id);

	public List<Product> getCategories();

	public Page<Product> getProduct(int page, int size, String sortBy, String sortDir);

}

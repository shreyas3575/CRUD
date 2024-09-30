package com.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.ProdcutDTO;
import com.application.model.Product;
import com.application.serviceInterface.ProductServiceInterface;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;

	@GetMapping("/show")
	public List<Product> viewProduct() {

		List<Product> list = productServiceInterface.viewProductList();
		return list;

	}

	@PostMapping("/add")
	public ProdcutDTO addProducts(@RequestBody ProdcutDTO prodcutDTO) {
		System.out.println(prodcutDTO.toString());

		boolean b = productServiceInterface.addProductDetails(prodcutDTO);

		if (b)

			return prodcutDTO;
		else
			return null;

	}

	@GetMapping("/getByProductId/{id}")
	public Optional<Product> findByProductId(@PathVariable("id") long id) {

		Optional<Product> product = productServiceInterface.findByProductId(id);

		if (product.isEmpty())
			return null;
		else
			return product;

	}

	@DeleteMapping("deleteById/{id}")
	public String deleteByProductId(@PathVariable("id") long id) {
		boolean b = productServiceInterface.deleteByProductId(id);

		if (b)
			return id + " Id is deleted....";
		else
			return id + " Id is not deleted....";
	}

	@GetMapping("/findAllProduct")
	public ResponseEntity<Page<Product>> findAllProduct(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {

		Page<Product> product = productServiceInterface.getProduct(page, size, sortBy, sortDir);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}

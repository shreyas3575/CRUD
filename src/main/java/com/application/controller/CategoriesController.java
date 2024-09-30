package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;
import com.application.serviceInterface.CategoriesInterface;

@RestController
@RequestMapping("/api/categories/")

public class CategoriesController {

	@Autowired

	private CategoriesInterface categoriesInterface;

	@PostMapping("addCategories")
	public String addCategories(@RequestBody CategoriesDTO categoriesDTO) {
		boolean b = categoriesInterface.addCategories(categoriesDTO);

		if (b)

			return "data added succesfully............";
		else
			return "data not added successfully.............";
	}

	@DeleteMapping("deletecategories/{id}")
	public String deleteCategories(@PathVariable("id") long id) {
		boolean b = categoriesInterface.deleteCategoriesById(id);

		if (b)
			return " Categories are deleted";
		else
			return " Categories are  not deleted";
	}

	@PutMapping("updateCategories/{id}")
	public String updateCategories(@PathVariable("id") long id, @RequestBody CategoriesDTO categoriesDTO) {

		System.out.println(categoriesDTO.toString());
		System.out.println(id);

		boolean b = categoriesInterface.updateCategories(categoriesDTO, id);

		if (b)
			return "categories are updated....";
		else
			return "categories are not updated....";
	}

	@GetMapping("findbyCategoriesId/{id}")
	public ResponseEntity<String> findbyCategoriesId(@PathVariable("id") long id) {

		Categories c = categoriesInterface.findbyCategoriesId(id);

		return new ResponseEntity<String>(c.toString(), HttpStatus.FOUND);

	}

	@GetMapping("getAllCategories")
	public ResponseEntity<String> getAllCategories() {
		List<Categories> categories = categoriesInterface.getCategories();
		return new ResponseEntity<String>(categories.toString(), HttpStatus.FOUND);

	}

	@GetMapping("/findAllCategories")
	public ResponseEntity<Page<Categories>> findAllCategories(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {

		 
		Page<Categories> categories = categoriesInterface.getCategories(page, size, sortBy, sortDir);

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

}

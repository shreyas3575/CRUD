package com.application.serviceInterface;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;

public interface CategoriesInterface {

	public boolean addCategories(CategoriesDTO dCtegoriesDTO);

	public boolean deleteCategoriesById(long id);

	public boolean updateCategories(CategoriesDTO categoriesDTO, long id);

	public Categories findbyCategoriesId(long id);

	public List<Categories> getCategories();

	public Page<Categories> getCategories(int page, int size, String sortBy, String sortDir);
}

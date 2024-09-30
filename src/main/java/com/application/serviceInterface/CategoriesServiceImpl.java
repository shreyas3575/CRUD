package com.application.serviceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.dto.CategoriesDTO;
import com.application.model.Categories;
import com.application.repository.CategoriesRopository;

@Service
public class CategoriesServiceImpl implements CategoriesInterface {

	@Autowired
	CategoriesRopository categoriesRopository;

	@Override
	public boolean addCategories(CategoriesDTO CtegoriesDTO) {

		Categories c = new Categories(CtegoriesDTO.getName());

		try {
			categoriesRopository.save(c);
			return true;
		} catch (Exception e) {

			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean deleteCategoriesById(long id) {

		try {
			categoriesRopository.deleteById(id);

			return true;
		} catch (Exception e) {

			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateCategories(CategoriesDTO categoriesDTO, long id) {

		// find id object data
		// replace data

		try {
			Categories c = categoriesRopository.findById(id).get();

			c.setName(categoriesDTO.getName());
 			categoriesRopository.save(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Categories findbyCategoriesId(long id) {

		return categoriesRopository.findById(id).get();
	}

	@Override
	public List<Categories> getCategories() {

		return categoriesRopository.findAll();
	}

	@Override
	public Page<Categories> getCategories(int page, int size, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);

		return categoriesRopository.findAll(pageable);
	}
}

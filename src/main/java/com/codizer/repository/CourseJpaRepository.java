package com.codizer.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codizer.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>{
	
	/**
	 * JpaRepository
	 * 
	 * Permite extender los metodos por defecto y mas usados,
	 * sin embargo, tambien permite definiar metodos personalizados
	 * de modo que genera un query de forma automatica
	 * 
	 * @param price
	 * @return
	 */
	public abstract Course findByPrice(int price);
	
	/**
	 * Como en el anterior, en este caso se monatiria un query
	 * de forma automatica pero con dos condiciones de busqueda
	 * @param price
	 * @param name
	 * @return
	 */
	public abstract Course findByPriceAndName(int price, String name);
	
	/**
	 * Genera un Query que realizara una busqueda por nombre y ordenado por la hora
	 * @param name
	 * @return
	 */
	public abstract List<Course> findByNameOrderByHours(String name);
	
	/**
	 * Genera un Query que realiza una busqueda por nombre o precio en la BD
	 * @param name
	 * @param price
	 * @return
	 */
	public abstract Course findByNameOrPrice(String name, int price);
}

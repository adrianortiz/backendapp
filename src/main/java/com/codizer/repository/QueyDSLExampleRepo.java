package com.codizer.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.codizer.entity.Course;
import com.codizer.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;


@Repository("queyDSLExampleRepo")
public class QueyDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	// Objeto que se encarga de jestionar las entidades de la persistencia
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist){
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if (exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		Course course1 = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		// Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		// List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
		return course1;
	}

}

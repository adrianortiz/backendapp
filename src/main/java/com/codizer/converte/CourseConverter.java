package com.codizer.converte;

import org.springframework.stereotype.Component;

import com.codizer.entity.Course;
import com.codizer.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	// Tranformar una entity a un model
	public CourseModel entity2Model(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		return courseModel;
	}
	
	// tranformar de un model a una entity
	public Course model2Entity(CourseModel courseModel) {
		Course course = new Course();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}
}

package com.nibi.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nibi.springdata.jpqlandnativesql.entities.Student;
import com.nibi.springdata.jpqlandnativesql.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlandnativesqlApplicationTests {

	
	@Autowired
	StudentRepository repository;
	
	@Test
	public void testStudentCreate() {
		
		Student student = new Student();
		student.setFirstName("Nibi");
		student.setLastName("Smirnov");
		student.setScore(88);
		
		Student student2 = new Student();
		student2.setFirstName("Gobi");
		student2.setLastName("Ferguson");
		student2.setScore(78);
		
		repository.save(student);
		repository.save(student2);
		
	}
	
	
	
	//
	@Test
	public void testFindAllStudents() {
		
		System.out.println(repository.findAllStudents(PageRequest.of(1, 5, Direction.ASC, "id")));
		
	}
	
	
	
	
	//
	@Test
	public void testFindAllStudentsPartialData() {
	
		List<Object[]> partialData = repository.finAllStudentsPartialData();
		for(Object[] objects : partialData) {
			
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			
		}
	}

	
	
	//
	@Test
	public void testFindAllStudentsByFirstName() {
		
		System.out.println(repository.findAllStudentsByFirstName("Nibi"));
		
	}
	
	
	
	
	//
	@Test
	public void testFindAllStudentsByScores() {
		
		System.out.println(repository.findStudentsForGivenScores(70, 80));
		
	}
	
	
	
	
	//
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentsByFirstName() {
		
		repository.deleteStudensByFirstname("Nibi");
		
	}
	
	
	
	//
	@Test
	public void testFindAllStudentNQ() {
		
		System.out.println(repository.findAllStudentNQ());
		
	}
	
	
	
	
	//
	@Test
	public void testFindByFirstNameNQ() {
		
		System.out.println(repository.findByFirstNQ("Nibi"));
	}
}

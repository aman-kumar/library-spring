package com.aman.libraryspring.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Student;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

	private StudentService service;

	@Mock
	private StudentDao studentDao;

	private Student student = new Student();

	private List<Student> studentList = new ArrayList<Student>();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new StudentService();
		service.setStudentDao(studentDao);
		studentList.add(student);
	}

	@Test
	public void testGetList() {
		when(studentDao.getList()).thenReturn(studentList);
		List<Student> resultList = service.getList();
		assertNotNull("list should not be null", resultList);
		verify(studentDao).getList();
	}

}

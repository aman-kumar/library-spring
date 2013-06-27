package com.aman.libraryspring.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import com.aman.libraryspring.domain.Student;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest {
	IssueService service;
	@Mock
	private StudentDao studentDao;

	@Mock
	private RecordDao recordDao;
	@Mock
	private List<Record> recordList;

	@Mock
	private Record record1;
	@Mock
	private Record record2;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new IssueService();
		service.setRecordDao(recordDao);
		service.setStudentDao(studentDao);
		recordList.add(record1);
		recordList.add(record2);

	}

	@Test
	public void testGetUpdatedRecord() {
		when(recordDao.getRecord()).thenReturn(recordList);
		List<Record> resultList = service.getUpdatedRecord();

		assertNotNull("list should not be null", resultList);
		verify(recordDao).getRecord();
	}

}

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

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.dao.StudentDao;
import com.aman.libraryspring.domain.Record;

@RunWith(MockitoJUnitRunner.class)
public class IssueServiceTest {
	IssueService service;
	@Mock
	private StudentDao studentDao;

	@Mock
	private RecordDao recordDao;

	private List<Record> recordList = new ArrayList<Record>();

	private Record record1 = new Record();

	private Record record2 = new Record();

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

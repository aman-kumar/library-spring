package com.aman.libraryspring.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.aman.libraryspring.dao.RecordDao;
import com.aman.libraryspring.domain.Book;
import com.aman.libraryspring.domain.Record;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {

	private RecordService recordService;

	@Mock
	private RecordDao recordDao;

	@Mock
	private Record record;

	@Mock
	private List<Record> recordList;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recordService = new RecordService();
		recordService.setRecordDao(recordDao);
		recordList.add(record);
	}

	@Test
	public void testGetList() {
		when(recordDao.listRecord()).thenReturn(recordList);
		List<Record> resultList = recordService.getList();

		assertNotNull("list should not be null", resultList);
		verify(recordDao).listRecord();

	}

}

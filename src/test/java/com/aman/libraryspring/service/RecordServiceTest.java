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
import com.aman.libraryspring.domain.Record;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {

	private RecordService recordService;

	@Mock
	private RecordDao recordDao;

	private Record record = new Record();

	private List<Record> recordList = new ArrayList<Record>();

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

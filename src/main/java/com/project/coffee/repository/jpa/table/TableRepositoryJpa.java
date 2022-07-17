package com.project.coffee.repository.jpa.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Table;
import com.project.coffee.repository.TableRepository;

@Service
@Primary
public class TableRepositoryJpa implements TableRepository {

	@Autowired
	private TableRepositoryJpaHelper tableRepositoryJpaHelper;
	
	
	@Override
	public List<Table> findAll() {
		return (List<Table>)tableRepositoryJpaHelper.findAll();
	}

}

package com.project.coffee.repository.mock;

import java.util.List;
import org.springframework.stereotype.Service;

import com.project.coffee.model.Table;
import com.project.coffee.repository.TableRepository;

@Service
public class TableRepositoryMock implements TableRepository {

    @Override
    public List<Table> findAll() {
        Table table = new Table();
        table.setId(1L);
        table.setName("Table 1");
        Table table2 = new Table();
        table2.setId(2L);
        table2.setName("Table 2");

        return List.of(table, table2);
    }
}

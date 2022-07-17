package com.project.coffee.services.table;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project.coffee.entities.Table;

@Service
public class TableServiceMock implements TableService {

    @Override
    public List<Table> findAll() {
        Table table = new Table();
        table.setId("1");
        table.setName("Table 1");
        Table table2 = new Table();
        table2.setId("2");
        table2.setName("Table 2");
        
        return List.of(table, table2);
    }
}

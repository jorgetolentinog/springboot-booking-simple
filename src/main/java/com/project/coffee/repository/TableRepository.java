package com.project.coffee.repository;
import java.util.List;

import com.project.coffee.model.Table;

public interface TableRepository {
    public List<Table> findAll();
}

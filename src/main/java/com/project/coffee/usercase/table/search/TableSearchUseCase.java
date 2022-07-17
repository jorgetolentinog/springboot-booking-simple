package com.project.coffee.usercase.table.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.coffee.model.Table;
import com.project.coffee.repository.TableRepository;

@Service
public class TableSearchUseCase {
    @Autowired
    private TableRepository tableService;

    @GetMapping("")
    public List<Table> list() {
        return tableService.findAll();
    }
}

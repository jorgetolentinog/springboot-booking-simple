package com.project.coffee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.Table;
import com.project.coffee.services.table.TableService;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("")
    public List<Table> index() {
        return tableService.findAll();
    }
}

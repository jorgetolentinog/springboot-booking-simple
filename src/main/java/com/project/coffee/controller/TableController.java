package com.project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.Table;
import com.project.coffee.repository.TableRepository;

@RestController
@RequestMapping("/tables")
public class TableController {
    @Autowired
    private TableRepository tableService;

    @GetMapping("")
    public List<Table> list() {
        return tableService.findAll();
    }
}

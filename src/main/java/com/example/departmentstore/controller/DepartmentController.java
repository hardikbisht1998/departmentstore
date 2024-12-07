package com.example.departmentstore.controller;


import com.example.departmentstore.DepartmentstoreApplication;
import com.example.departmentstore.dto.DepartmentDTO;

import com.example.departmentstore.entity.DepartmentEntity;
import com.example.departmentstore.exception.ResourceNotFoundException;
import com.example.departmentstore.service.DepartmentService;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@RestController
//@RequestMapping("/departments")


@RestController
@RequestMapping(path="/departments")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;

    @Autowired
    ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        return  ResponseEntity.ok(departmentService.getAllDepartment());


    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.createDepartment(departmentDTO),HttpStatus.CREATED);

    }


    @PutMapping(path="/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable long id ,@RequestBody DepartmentDTO departmentDTO) throws ResourceNotFoundException {
        return new ResponseEntity<>(departmentService.updateDepartment(id,departmentDTO),HttpStatus.ACCEPTED);

    }

    @GetMapping(path="/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable long id){
        return new ResponseEntity<>(departmentService.getDepartmentById(id),HttpStatus.FOUND);
    }



    @DeleteMapping(path="{id}")
    public ResponseEntity<String> removeDepartmentById(@PathVariable long id){
        departmentService.removeDepartmentById(id);
        return new ResponseEntity<>("Department of Id :"+id +" Removed",HttpStatus.OK);
    }









}

package com.example.departmentstore.service;


import com.example.departmentstore.dto.DepartmentDTO;

import com.example.departmentstore.entity.DepartmentEntity;
import com.example.departmentstore.exception.ResourceNotFoundException;
import com.example.departmentstore.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper mapper;

    public List<DepartmentDTO> getAllDepartment() {

        return departmentRepository.findAll().stream().map(x->mapper.map(x,DepartmentDTO.class)).collect(Collectors.toList());
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity department=departmentRepository.save(mapper.map(departmentDTO, DepartmentEntity.class));
        return mapper.map(department,DepartmentDTO.class);


    }


    public DepartmentDTO updateDepartment(long id ,DepartmentDTO departmentDTO)  {
       if(isExist(id)) {
           departmentDTO.setId(id);
           DepartmentEntity department = departmentRepository.save(mapper.map(departmentDTO, DepartmentEntity.class));
           return mapper.map(department, DepartmentDTO.class);
       }
        return new DepartmentDTO();
    }

    private boolean isExist(Long id) {
        if(departmentRepository.existsById(id))
          return true;

        throw new ResourceNotFoundException("Depatment not found of id "+ id);
    }

    public DepartmentDTO getDepartmentById(long id) {
        if(isExist(id))
            return mapper.map(departmentRepository.findById(id),DepartmentDTO.class);

        return new DepartmentDTO();
    }

    public void removeDepartmentById(long id) {

        if(isExist(id))
            departmentRepository.deleteById(id);
    }
}

package com.example.departmentstore.repository;


import com.example.departmentstore.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}

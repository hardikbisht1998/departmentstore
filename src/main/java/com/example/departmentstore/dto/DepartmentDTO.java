package com.example.departmentstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

//    @JsonProperty("id")
    private Long id;

//    @JsonProperty("title")
    private String title;
    @JsonProperty("isActive")
    private boolean isActive;

//    @JsonProperty("createdAt")

    private LocalDate createdAt;


}

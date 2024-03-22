package com.schoolmate.admissionregistration.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SchoolDetails {

    private Integer schoolId;
    private String schoolName;

}

package com.naveen.springprofileenv.model;

import com.naveen.springprofileenv.entity.University;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UniversityDTO {
    private Long id;
    private String name;
    private List<CollegeDTO> colleges;

    public static UniversityDTO mapToUniversity(University university) {
        return UniversityDTO.builder()
                .id(university.getId())
                .name(university.getName())
                .colleges(CollegeDTO.mapToCollege(university.getColleges()))
                .build();
    }
}

package com.naveen.springprofileenv.model;

import com.naveen.springprofileenv.entity.College;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CollegeDTO {
    private Long id;
    private String name;
    private String city;
    private String state;
    private String location;

    public static List<CollegeDTO> mapToCollege(List<College> colleges) {
        return colleges.stream().map(CollegeDTO::getCollegeDTO).collect(Collectors.toList());

    }
    private static CollegeDTO getCollegeDTO(College college) {
        return CollegeDTO.builder().city(college.getCity()).id(college.getId()).name(college.getName())
                .state(college.getState()).location(college.getLocation()).build();
    }
}

package com.naveen.springprofileenv.controller;

import com.naveen.springprofileenv.entity.University;
import com.naveen.springprofileenv.model.UniversityDTO;
import com.naveen.springprofileenv.repo.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UniversityController {

    private final UniversityRepository universityRepository;

    @GetMapping("/university")
    public ResponseEntity<List<UniversityDTO>> getAllUniversities() {
        List<University> universities = universityRepository.findAll();
        List<UniversityDTO> universityDTOS = null;
        if (!CollectionUtils.isEmpty(universities)) {
            universityDTOS = universities.stream().map(UniversityDTO::mapToUniversity)
                    .collect(Collectors.toList());

        }
        return ResponseEntity.ok(universityDTOS);
    }

    @GetMapping("/university/{id}")
    public ResponseEntity<UniversityDTO> getUniversity(final @PathVariable Long id) {
        University university = universityRepository.findById(id).orElseThrow(() -> new
                RuntimeException("University not found")) ;
        UniversityDTO universityDTO = UniversityDTO.mapToUniversity(university);
        return ResponseEntity.ok(universityDTO);
    }
}

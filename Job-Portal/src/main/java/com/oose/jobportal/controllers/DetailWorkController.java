package com.oose.jobportal.controllers;

import com.oose.jobportal.constants.Domain;
import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.mappers.DetailWorkMapper;
import com.oose.jobportal.services.DetailWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/detailwork")
@CrossOrigin(Domain.CROSS_ORIGIN)
public class DetailWorkController {
    @Autowired
    private DetailWorkService detailWorkService;

    @GetMapping("/find-all-detailwork")
    public ResponseEntity<?> getAllDetailWork() {
        List<DetailWorkDto> detailWorkDtoList = DetailWorkMapper.mappingToListDto(detailWorkService.findAll());

        return ResponseEntity.ok(detailWorkDtoList);


    }
}

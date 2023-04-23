package com.oose.jobportal.controllers;

import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.dtos.TypeWorkDto;
import com.oose.jobportal.models.dtos.WorkDto;
import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.models.entities.TypeWork;
import com.oose.jobportal.models.entities.Work;
import com.oose.jobportal.models.mappers.DetailWorkMapper;
import com.oose.jobportal.models.mappers.TypeworkMapper;
import com.oose.jobportal.models.mappers.WorkMapper;
import com.oose.jobportal.services.DetailWorkService;
import com.oose.jobportal.services.TypeWorkService;
import com.oose.jobportal.services.WorkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/work")
@CrossOrigin("http://127.0.0.1:5501/")
public class WorkController {
    @Autowired
    WorkService workService;
    @Autowired
    DetailWorkService detailWorkService;
    @Autowired
    TypeWorkService typeWorkService;

    @GetMapping("/top10-work")
    public ResponseEntity<?> getTop10Work() {
        Calendar calendar = Calendar.getInstance();
        Date current = calendar.getTime();

        List<Work> workList = workService.findTop10Work(current);
        List<WorkDto> workDtoList = WorkMapper.mappingToListWork(workList);

        return ResponseEntity.ok(workDtoList);
    }

    // Kiểm tra lại
    @GetMapping("/detailwork")
    public ResponseEntity<?> getDetailWork(@Valid @RequestParam int id) {
        if (id != 0) {
            DetailWork detailWork = detailWorkService.findByID(id);
            DetailWorkDto detailWorkDto = DetailWorkMapper.mappingToDto(detailWork);

            return ResponseEntity.ok(detailWorkDto);
        }
        List<DetailWork> detailWorkList = detailWorkService.findAll();
        List<DetailWorkDto> detailWorkDtoList = DetailWorkMapper.mappingToListDto(detailWorkList);

        return ResponseEntity.ok(detailWorkDtoList);
    }

    @GetMapping("/typework")
    public ResponseEntity<?> getTypeWork(@Valid @RequestParam int id) {
        if (id != 0) {
            TypeWork typeWork = typeWorkService.findByID(id);
            TypeWorkDto typeWorkDto = TypeworkMapper.mappingToDto(typeWork);
            return ResponseEntity.ok(typeWorkDto);
        }

        List<TypeWork> typeWorkList = typeWorkService.findAll();
        List<TypeWorkDto> typeWorkDtoList = TypeworkMapper.mappingToListDto(typeWorkList);
        return ResponseEntity.ok(typeWorkDtoList);
    }
}

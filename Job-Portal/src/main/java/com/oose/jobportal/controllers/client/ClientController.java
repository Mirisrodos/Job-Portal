package com.oose.jobportal.controllers.client;

import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.dtos.WorkDto;
import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.models.entities.Work;
import com.oose.jobportal.models.mappers.DetailWorkMapper;
import com.oose.jobportal.models.mappers.WorkMapper;
import com.oose.jobportal.repositories.WorkRepo;
import com.oose.jobportal.services.DetailWorkService;
import com.oose.jobportal.services.WorkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/client")
@CrossOrigin("http://127.0.0.1:5501/")
public class ClientController {
    @Autowired
    WorkService workService;
    @Autowired
    DetailWorkService detailWorkService;

    @GetMapping("/top10-work")
    public ResponseEntity<?> getTop10Work() {
        Calendar calendar = Calendar.getInstance();
        Date current = calendar.getTime();

        List<Work> workList = workService.findTop10Work(current);
        List<WorkDto> workDtoList = WorkMapper.mappingToListWork(workList);

        return ResponseEntity.ok(workDtoList);
    }

    @GetMapping("/detailwork")
    public ResponseEntity<?> getDetailWork(@Valid @RequestParam int id) {
        DetailWork detailWork = detailWorkService.findDetailWorkByID(id);
        DetailWorkDto detailWorkDto = DetailWorkMapper.mappingToDetailWorkDto(detailWork);

        return ResponseEntity.ok(detailWorkDto);
    }
}

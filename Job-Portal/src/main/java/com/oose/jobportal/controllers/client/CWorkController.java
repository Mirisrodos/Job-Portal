package com.oose.jobportal.controllers.client;

import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.dtos.WorkDto;
import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.models.entities.Work;
import com.oose.jobportal.services.DetailWorkService;
import com.oose.jobportal.services.TypeWorkService;
import com.oose.jobportal.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client/work")
@CrossOrigin("http://127.0.0.1:5501/")
public class CWorkController {
    @Autowired
    WorkService workService;
    @Autowired
    DetailWorkService detailWorkService;
    @Autowired
    TypeWorkService typeWorkService;

    @PostMapping("/createWork")
    public ResponseEntity<?> createWork(@RequestBody WorkDto workDto) {
        Work work = new Work();

        work.setDate(workDto.getDate());
        work.setLocation(workDto.getLocation());
        work.setQuantity(workDto.getQuantity());
        work.setWorkname(workDto.getWorkname());
        work.setDetailwork(detailWorkService.findByID(workDto.getDetailworkID()));
        work.setType_work(typeWorkService.findByID(workDto.getTypeworkID()));

        return ResponseEntity.ok(workService.save(work));
    }

    @PostMapping("/createDetail")
    public ResponseEntity<?> createDetailWork(@RequestBody DetailWorkDto detailWorkDto) {
        DetailWork detailWork = new DetailWork();

        detailWork.setContact(detailWorkDto.getContact());
        detailWork.setDescription(detailWorkDto.getDescription());
        detailWork.setHours(detailWorkDto.getHours());
        detailWork.setIncome(detailWorkDto.getIncome());

        return ResponseEntity.ok(detailWorkService.save(detailWork)) ;
    }
}

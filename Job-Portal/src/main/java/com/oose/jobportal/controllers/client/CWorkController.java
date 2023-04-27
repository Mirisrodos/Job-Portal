package com.oose.jobportal.controllers.client;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.oose.jobportal.models.dtos.DetailWorkDto;
import com.oose.jobportal.models.dtos.WorkDto;
import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.models.entities.Work;
import com.oose.jobportal.models.mappers.DetailWorkMapper;
import com.oose.jobportal.models.mappers.WorkMapper;
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
    private WorkService workService;
    @Autowired
    private DetailWorkService detailWorkService;
    @Autowired
    private TypeWorkService typeWorkService;

    @PostMapping("/createWork")
    public ResponseEntity<?> createWork(@RequestBody WorkDto workDto) {
        Work work = new Work();

        // Lỗi Mapper (detailworkService để private static không gọi được findByID (findByID = null))
        work.setDate(workDto.getDate());
        work.setLocation(workDto.getLocation());
        work.setQuantity(workDto.getQuantity());
        work.setWorkname(workDto.getWorkname());
        work.setDetailwork(detailWorkService.findByID(workDto.getDetailworkID()));
        work.setType_work(typeWorkService.findByID(workDto.getTypeworkID()));

        return ResponseEntity.ok(workService.save(work).getWorkID());
    }

    @PostMapping("/createDetail")
    public ResponseEntity<?> createDetailWork(@RequestBody DetailWorkDto detailWorkDto) {

        DetailWork detailWork = DetailWorkMapper.mappingToEntity(detailWorkDto);

        return ResponseEntity.ok(detailWorkService.save(detailWork).getDetailworkID());
    }
}
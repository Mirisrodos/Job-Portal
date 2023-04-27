package com.oose.jobportal.models.mappers;

import com.oose.jobportal.models.dtos.WorkDto;
import com.oose.jobportal.models.entities.Work;
import com.oose.jobportal.services.DetailWorkService;
import com.oose.jobportal.services.TypeWorkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class WorkMapper {
    @Autowired
    private static DetailWorkService detailWorkService;
    @Autowired
    private static TypeWorkService typeWorkService;

    public static WorkDto mappingToDto(Work work) {
        WorkDto workDto = new WorkDto();

        if(work != null) {
            workDto.setWorkID(work.getWorkID());
            workDto.setDate(work.getDate());
            workDto.setLocation(work.getLocation());
            workDto.setQuantity(work.getQuantity());
            workDto.setWorkname(work.getWorkname());
            workDto.setDetailworkID(work.getDetailwork().getDetailworkID());
            workDto.setTypeworkID(work.getType_work().getTypeworkID());
            workDto.setImage(work.getImage());
            workDto.setInvolved(work.getInvolved());
        } else {
            workDto.setWorkID(-1);
            workDto.setDate(null);
            workDto.setLocation("");
            workDto.setQuantity(0);
            workDto.setWorkname("");
            workDto.setDetailworkID(0);
            workDto.setTypeworkID(0);
            workDto.setImage("");
            workDto.setInvolved(0);
        }

        return workDto;
    }

    public static List<WorkDto> mappingToListWork(List<Work> workList) {
        List<WorkDto> workDtoList = new ArrayList<>();

        if (workList == null)
        {
            workDtoList.add(mappingToDto(null));
            return workDtoList;
        }

        for(Work work : workList) {
            workDtoList.add(mappingToDto(work));
        }

        return workDtoList;
    }

    public static Work mappingToEntity(WorkDto workDto) {
        Work work = new Work();

        if (workDto != null) {
            work.setDate(workDto.getDate());
            work.setLocation(workDto.getLocation());
            work.setQuantity(workDto.getQuantity());
            work.setWorkname(workDto.getWorkname());
            work.setDetailwork(detailWorkService.findByID(workDto.getDetailworkID()));
            work.setType_work(typeWorkService.findByID(workDto.getTypeworkID()));
        } else {
            work.setDate(null);
            work.setLocation("");
            work.setQuantity(0);
            work.setWorkname("");
            work.setDetailwork(null);
            work.setType_work(null);
        }

        return work;
    }
}

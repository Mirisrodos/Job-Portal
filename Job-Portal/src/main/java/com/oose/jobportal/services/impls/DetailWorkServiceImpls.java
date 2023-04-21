package com.oose.jobportal.services.impls;

import com.oose.jobportal.models.entities.DetailWork;
import com.oose.jobportal.repositories.DetailWorkRepo;
import com.oose.jobportal.services.DetailWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailWorkServiceImpls implements DetailWorkService {

    @Autowired
    DetailWorkRepo detailWorkRepo;

    @Override
    public DetailWork findDetailWorkByID(int id) {
        return detailWorkRepo.findById(id).orElse(null);
    }
}

package com.oose.jobportal.controllers;

import com.oose.jobportal.constants.Domain;
import com.oose.jobportal.models.dtos.PaymentDto;
import com.oose.jobportal.models.entities.Payment;
import com.oose.jobportal.models.mappers.PaymentMapper;
import com.oose.jobportal.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(Domain.CROSS_ORIGIN)
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("save-payment")
    public ResponseEntity<?> createPayment(@RequestBody PaymentDto paymentDto) {
        Payment payment = PaymentMapper.mappingToEntity(paymentDto);

        return ResponseEntity.ok(PaymentMapper.mappingToDto(paymentService.save(payment)));
    }
}

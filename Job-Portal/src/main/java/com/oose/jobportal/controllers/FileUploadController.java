package com.oose.jobportal.controllers;

import com.oose.jobportal.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        return ResponseEntity.ok(fileUploadService.uploadFile(multipartFile));
    }

    @DeleteMapping("/destroyFile")
    public ResponseEntity<?> destroyFile(@RequestBody Map map) throws IOException {
        return ResponseEntity.ok(fileUploadService.destroyFile(map));
    }
}

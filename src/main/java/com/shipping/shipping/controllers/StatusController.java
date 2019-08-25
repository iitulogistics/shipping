package com.shipping.shipping.controllers;

import com.shipping.shipping.services.StatusService;
import com.shipping.shipping.services.impl.DefaultStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("status")
public class StatusController {
    private StatusService statusService;

    @Autowired(required = false)
    @Qualifier("defaultStatusService")
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(statusService.getStatuses());
    }

    @GetMapping("getStatusById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(statusService.getStatusById(id));
    }

    @PostMapping("addStatus")
    public ResponseEntity<?> addStatus(@RequestParam String status,
                                       @RequestParam String addInfo) {
        return ResponseEntity.ok(statusService.addStatus(status, addInfo));
    }

    @PatchMapping("updateStatus")
    public ResponseEntity<?> updateStatus(@RequestParam Long id,
                                          @RequestParam String status,
                                          @RequestParam String addInfo) {
        return ResponseEntity.ok(statusService.updateStatusById(id, status, addInfo));
    }

    @DeleteMapping("deleteStatusById")
    public ResponseEntity<?> deleteStatusById(@RequestParam Long id) {
        return ResponseEntity.ok(statusService.deleteStatusById(id));
    }
}

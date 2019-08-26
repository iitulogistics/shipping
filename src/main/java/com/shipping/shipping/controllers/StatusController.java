package com.shipping.shipping.controllers;

import com.shipping.shipping.services.StatusService;
import com.shipping.shipping.services.impl.DefaultStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("status")
@Api(tags = "Список статусов", description = "Api для списка статусов")
public class StatusController {
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation("Список статусов")
    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(statusService.getStatuses());
    }

    @ApiOperation("Вернуть статус по id")
    @GetMapping("getStatusById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(statusService.getStatusById(id));
    }

    @ApiOperation("Добавить статус")
    @PostMapping("addStatus")
    public ResponseEntity<?> addStatus(@RequestParam String status,
                                       @RequestParam String addInfo) {
        return ResponseEntity.ok(statusService.addStatus(status, addInfo));
    }

    @ApiOperation("Обновить статус")
    @PatchMapping("updateStatus")
    public ResponseEntity<?> updateStatus(@RequestParam Long id,
                                          @RequestParam String status,
                                          @RequestParam String addInfo) {
        return ResponseEntity.ok(statusService.updateStatusById(id, status, addInfo));
    }

    @ApiOperation("Удалить статус")
    @DeleteMapping("deleteStatusById")
    public ResponseEntity<?> deleteStatusById(@RequestParam Long id) {
        return ResponseEntity.ok(statusService.deleteStatusById(id));
    }
}

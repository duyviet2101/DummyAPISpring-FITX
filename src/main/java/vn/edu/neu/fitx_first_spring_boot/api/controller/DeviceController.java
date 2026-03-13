package vn.edu.neu.fitx_first_spring_boot.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.neu.fitx_first_spring_boot.api.dto.in.DeviceDtoIn;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;
import vn.edu.neu.fitx_first_spring_boot.api.service.DeviceService;
import vn.edu.neu.fitx_first_spring_boot.common.response.ApiResponse;

import java.util.HashMap;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDevices() {
        return ResponseEntity.ok(ApiResponse.success(deviceService.getAllDevices()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeviceById(@PathVariable String id) {
        Device device = deviceService.getDeviceById(id);
        if (device != null) {
            return ResponseEntity.ok(ApiResponse.success(device));
        } else {
            return ResponseEntity.status(404).body(ApiResponse.error(404, HttpStatus.NOT_FOUND, "Device not found"));
        }
    }

    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody @Valid DeviceDtoIn device) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(deviceService.createDevice(device)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDevice(@PathVariable String id, @RequestBody Device device) {
        return ResponseEntity.ok(ApiResponse.success(deviceService.updateDevice(id, device)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDevice(@PathVariable String id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.ok(ApiResponse.success(new HashMap<>()));
    }
}

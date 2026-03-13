package vn.edu.neu.fitx_first_spring_boot.api.service;

import org.springframework.stereotype.Service;
import vn.edu.neu.fitx_first_spring_boot.api.dto.in.DeviceDtoIn;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;
import vn.edu.neu.fitx_first_spring_boot.api.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(DeviceDtoIn dto) {
        Device newDevice = new Device(null, dto.getName(), dto.getManufacture());
        return deviceRepository.save(newDevice);
    }

    public Device updateDevice(Long id, DeviceDtoIn dto) {
        Optional<Device> existing = deviceRepository.findById(id);
        if (existing.isEmpty()) return null;
        Device device = existing.get();
        device.setName(dto.getName());
        device.setManufacture(dto.getManufacture());
        return deviceRepository.save(device);
    }

    public boolean deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) return false;
        deviceRepository.deleteById(id);
        return true;
    }
}

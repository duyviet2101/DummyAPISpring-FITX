package vn.edu.neu.fitx_first_spring_boot.api.service;

import org.springframework.stereotype.Service;
import vn.edu.neu.fitx_first_spring_boot.api.dto.in.DeviceDtoIn;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;
import vn.edu.neu.fitx_first_spring_boot.api.repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(String id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(DeviceDtoIn dto) {
        Device newDevice = new Device(null, dto.getName(), dto.getManufacture());
        return deviceRepository.save(newDevice);
    }

    public Device updateDevice(String id, Device device) {
        if (!deviceRepository.existsById(id)) return null;
        device.setId(id);
        return deviceRepository.save(device);
    }

    public boolean deleteDevice(String id) {
        if (!deviceRepository.existsById(id)) return false;
        deviceRepository.deleteById(id);
        return true;
    }
}

package vn.edu.neu.fitx_first_spring_boot.api.service;

import org.springframework.stereotype.Service;
import vn.edu.neu.fitx_first_spring_boot.api.dto.in.DeviceDtoIn;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DeviceService {
    private final Map<Long, Device> devices = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Device> getAllDevices() {
        return new ArrayList<>(devices.values());
    }

    public Device getDeviceById(Long id) {
        return devices.get(id);
    }

    public Device createDevice(DeviceDtoIn dto) {
        Long id = idGenerator.getAndIncrement();
        Device newDevice = new Device(id, dto.getName(), dto.getManufacture());
        devices.put(id, newDevice);
        return newDevice;
    }

    public Device updateDevice(Long id, Device device) {
        if (!devices.containsKey(id)) return null;
        device.setId(id);
        devices.put(id, device);
        return device;
    }

    public boolean deleteDevice(Long id) {
        return devices.remove(id) != null;
    }
}

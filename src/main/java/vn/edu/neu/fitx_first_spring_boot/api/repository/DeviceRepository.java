package vn.edu.neu.fitx_first_spring_boot.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {
}

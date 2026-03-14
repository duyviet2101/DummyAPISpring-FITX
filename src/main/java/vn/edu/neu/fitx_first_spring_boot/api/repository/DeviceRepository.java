package vn.edu.neu.fitx_first_spring_boot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.neu.fitx_first_spring_boot.api.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}

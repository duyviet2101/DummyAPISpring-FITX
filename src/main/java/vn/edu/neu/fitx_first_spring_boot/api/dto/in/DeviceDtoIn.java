package vn.edu.neu.fitx_first_spring_boot.api.dto.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeviceDtoIn {
    @NotEmpty()
    @Size(max = 255)
    private String name;

    @NotEmpty()
    @Size(max = 255)
    private String manufacture;
}

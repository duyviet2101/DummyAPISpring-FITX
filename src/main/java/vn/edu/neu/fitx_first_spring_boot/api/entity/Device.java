package vn.edu.neu.fitx_first_spring_boot.api.entity;

public class Device {
    private Long id;
    private String name;
    private String manufacture;

    public Device() {}

    public Device(Long id, String name, String manufacture) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}


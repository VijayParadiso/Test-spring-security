package ind.vijay.demo.bean;

import lombok.Data;

@Data
public class Role {
    private Short id;
    private String name;
    private String namezh;
    private String description;
    private Boolean enabled;
    private Integer accessCode;
}
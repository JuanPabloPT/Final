package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JobOffer {
    private Long id;
    private String name;
    private String description;
    private Double salary;
    private String type;
    private Date date;
    private String experience;
    private Date createdAt;
    private String status;
}

package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Contract {
    private Long id;
    private String description;
    private Boolean confirmation;
    private Date createdAt;
    private String status;
    private JobOffer jobOffer;
}

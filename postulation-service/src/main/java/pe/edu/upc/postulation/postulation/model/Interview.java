package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Interview {
    private Long id;
    private String link;
    private Date date;
    private Boolean pending;
    private JobOffer jobOffer;
}

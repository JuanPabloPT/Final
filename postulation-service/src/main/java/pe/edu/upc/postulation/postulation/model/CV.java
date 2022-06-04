package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CV {
    private Long id;
    private String ocupation;
    private String video;
    private String experience;
    private Postulant postulant;
}

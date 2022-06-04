package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Skill {
    private Long id;
    private String name;
    private String description;
    private CV cv;
}

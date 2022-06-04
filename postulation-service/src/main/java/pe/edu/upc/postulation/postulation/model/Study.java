package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Study {
    private Long id;
    private String name;
    private Integer degree;
    private CV cv;
}

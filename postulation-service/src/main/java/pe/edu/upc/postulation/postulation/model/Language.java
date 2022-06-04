package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Language {
    private Long id;
    private String name;
    private Integer level;
    private CV cv;
}

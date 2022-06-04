package pe.edu.upc.postulation.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Postulant {
    private Long id;
    private String firstName;
    private String lastName;
    private String number;
    private String email;
    private String password;
    private String document;
    private String civilStatus;
    private Date birthday;
}

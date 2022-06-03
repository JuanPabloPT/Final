package upc.edu.pe.postulantmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "tbl_postulants")
@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe quedar vacío")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "El apellido no debe quedar vacío")
    @Column(name = "last_name")
    private String lastName;

    private String number;

    @NotEmpty(message = "El email no debe quedar vacío")
    @Email
    private String email;

    @NotEmpty(message = "La contraseña no debe quedar vacío")
    private String password;

    private String document;

    @Column(name = "civil_status")
    private String civilStatus;

    @Temporal(TemporalType.DATE)
    private Date birthday;

}

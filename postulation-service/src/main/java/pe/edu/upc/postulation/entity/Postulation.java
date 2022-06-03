package pe.edu.upc.postulation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_postulations")
public class Postulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_postulation")
    private String numberPostulation;

    @Column(name = "joboffer_id")
    private Long jobOfferId;

    //@Transient
    //private JobOffer jobOffer;

    private String state;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializar", "handler"})
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="postulants_id")
    private List<PostulantsCV> list;

    public Postulation() {list = new ArrayList<>();}

}

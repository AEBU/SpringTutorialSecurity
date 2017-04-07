package securityinmemory.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Alexis on 05/04/2017.
 */
@Entity
@Data
@Table(name = "canton")
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cntId;
    private String cntNombre;
    private String cntDescripcion;
}


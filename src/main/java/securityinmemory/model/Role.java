package securityinmemory.model;


import javax.persistence.*;
import java.util.List;


/**
 * Created by Alexis on 01/04/2017.
 */


@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rlId;

    private String rlName;
    @ManyToMany(mappedBy = "roles")
    private List<User> rlUsers;

}
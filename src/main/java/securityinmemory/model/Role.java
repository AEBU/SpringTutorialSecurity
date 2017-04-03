package securityinmemory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


/**
 * Created by Alexis on 01/04/2017.
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rlId;

    private String rlName;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "role_user", joinColumns =@JoinColumn(name = "role_id", referencedColumnName = "rlId")
//            ,inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"))
//    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> rlUsers;

    public Role(String rlName) {
        this.rlName = rlName;
    }


    @Override
    public String toString() {
        return "Role{" +
                "rlId=" + rlId +
                ", rlName='" + rlName + '\'' +
                ", rlUsers=" + rlUsers +
                '}';
    }
}
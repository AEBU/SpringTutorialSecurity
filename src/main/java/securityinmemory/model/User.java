package securityinmemory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexis on 01/04/2017.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private Boolean enabled;

    // Make sense to Eager fetch user's authorities


    //    @ManyToMany(mappedBy = "rlUsers")

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "rlId"))
    private List<Role> roles;

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, Boolean enabled, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }


}

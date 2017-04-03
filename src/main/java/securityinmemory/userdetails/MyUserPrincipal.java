package securityinmemory.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.annotation.SessionScope;
import securityinmemory.model.Role;
import securityinmemory.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexis on 03/04/2017.
 * Clase que hará que implemente las autoridades de cada usuario ya sea con rol de usuario o rol de administrador
 * References
 *              http://www.baeldung.com/spring-security-authentication-with-a-database
 */
@SessionScope
public class MyUserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for ( Role privilege : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(privilege.getRlName()));
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
//        return user.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        return user.isAccountNonLocked();
        return true;
    }



    @Override
    public boolean isCredentialsNonExpired() {
//        return user.isCredentialsNonExpired();
        return true;

    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}

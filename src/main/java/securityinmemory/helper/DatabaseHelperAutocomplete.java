package securityinmemory.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import securityinmemory.model.Role;
import securityinmemory.model.User;
import securityinmemory.repository.RoleRepository;
import securityinmemory.repository.UserRepository;

import javax.persistence.RollbackException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexis on 01/04/2017.
 *
 * This class will help us to autocomplete with elemts
 * in the moment when initialize our app
 */

@Component
public class DatabaseHelperAutocomplete implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public DatabaseHelperAutocomplete(RoleRepository roleRepository,UserRepository userRepository){
        this.roleRepository = roleRepository;
        this.userRepository=userRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        //        ***************Creamos los Roles***************

        Role admin=new Role("ROLE_ADMIN");
        Role user=new Role("ROLE_USER");
        roleRepository.save(admin);
        roleRepository.save(user);
        List<Role> rolesAdmin=new ArrayList<>();
        List<Role> rolesUser=new ArrayList<>();
        rolesAdmin.add(admin);
        rolesAdmin.add(user);
        System.out.println("Roles Admin"+rolesAdmin);
        rolesUser.add(user);
        System.out.println("Roles User"+rolesUser);




        //        ***************Creamos los Usuarios***************
        User elizabeth=new User("elizabeth","gatos",true);
        User alexis=new User("alexis","papi",true);
        User isolina=new User("isolina","mamita",true);
        User gabirara=new User("gabisita","carneiuu",true);

        //        ***************les damos los roles**************
        elizabeth.setRoles(rolesUser);
        alexis.setRoles(rolesAdmin);
        isolina.setRoles(rolesAdmin);
        gabirara.setRoles(rolesAdmin);

        userRepository.save(elizabeth);
        userRepository.save(alexis);

        List<User> users=new ArrayList<>();
        users.add(elizabeth);
        users.add(alexis);
        users.add(isolina);
        users.add(gabirara);
///
        userRepository.save(users);


        System.out.println("User" +
                "/n"+users);
    }

}


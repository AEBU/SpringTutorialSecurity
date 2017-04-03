package securityinmemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securityinmemory.model.User;

/**
 * Created by Alexis on 01/04/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername (String email);

}


